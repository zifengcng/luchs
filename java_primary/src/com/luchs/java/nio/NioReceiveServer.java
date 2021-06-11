package com.luchs.java.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author cheng
 * @Date 2021/5/18
 */
public class NioReceiveServer {

    private static Map<SelectableChannel, Client> clientMap = new HashMap<>();

    private static ByteBuffer buffer = ByteBuffer.allocate(1024);

    private static Charset charset = StandardCharsets.UTF_8;

    public static void main(String[] args) throws IOException {
        startServer();
    }

    private static void startServer() throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("localhost", 18899));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel)selectionKey.channel();
                    SocketChannel socketChannel = server.accept();
                    if (socketChannel == null) {
                        continue;
                    }
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    Client client = new Client();
                    client.remoteAddress = (InetSocketAddress) socketChannel.getRemoteAddress();
                    clientMap.put(socketChannel, client);
                } else if (selectionKey.isReadable()) {
                    processData(selectionKey);
                }
                iterator.remove();
            }
        }
        serverSocketChannel.close();
    }

    private static void processData(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        Client client = clientMap.get(socketChannel);

        int num = 0;

        try {
            buffer.clear();
            while ((num = socketChannel.read(buffer)) > 0) {
                buffer.flip();
                // 首先处理文件名
                if (client.fileName == null) {
                    if (buffer.capacity() < 4) {
                        continue;
                    }
                    int fileNameLength = buffer.getInt();
                    byte[] fileNameBytes = new byte[fileNameLength];
                    buffer.get(fileNameBytes);

                    // 文件名
                    String fileName = new String(fileNameBytes, charset);
                    client.fileName = fileName;

                    String destPath = "D:\\BaiduNetdiskDownload";
                    File directory = new File(destPath);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    String fullName = destPath + File.separator + fileName;

                    File file = new File(fullName.trim());
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileChannel fileChannel = new FileInputStream(file).getChannel();
                    client.fileChannel = fileChannel;

                    if (buffer.capacity() < 8) {
                        continue;
                    }
                    long fileLength = buffer.getLong();
                    client.fileLength = fileLength;
                    client.startTime = System.currentTimeMillis();
                    System.out.println("传输开始");

                    client.receiveLength += buffer.capacity();
                    if (buffer.capacity() > 0) {
                        // 写入文件
                        client.fileChannel.write(buffer);
                    }
                    if (client.isFinished()) {
                        finished(selectionKey, client);
                    }
                    buffer.clear();
                } else {
                    // 文件内容
                    client.receiveLength += buffer.capacity();
                    client.fileChannel.write(buffer);
                    if (client.isFinished()) {
                        finished(selectionKey, client);
                    }
                    buffer.clear();
                }
            }
            selectionKey.cancel();
        } catch (IOException e) {
            selectionKey.cancel();
            e.printStackTrace();
            return;
        }
        if (num == -1) {
            finished(selectionKey, client);
            buffer.clear();
        }
    }

    private static void finished(SelectionKey selectionKey, Client client) throws IOException {
        client.fileChannel.close();
        System.out.println("上传完毕");
        selectionKey.cancel();
        System.out.println("文件接收成功，fileName = " + client.fileName);

        System.out.println(" Size :" + client.fileLength);

        System.out.println("NIO IO 传输毫秒数：" + (System.currentTimeMillis() - client.startTime));
    }

    static class Client {

        // 文件名称
        String fileName;

        // 长度
        long fileLength;

        // 开始传输时间
        long startTime;

        // 客户端地址
        InetSocketAddress remoteAddress;

        // 输出的文件通道
        FileChannel fileChannel;

        // 接收长度
        long receiveLength;

        public boolean isFinished() {
            return receiveLength >= fileLength;
        }
    }
}
