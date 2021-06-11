package com.luchs.java.nio;

import sun.misc.CharacterEncoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/**
 * @Author cheng
 * @Date 2021/5/18
 */
public class SocketChannelDemo {

    private static Charset charset = StandardCharsets.UTF_8;

    public static void main(String[] args) throws IOException {
        sendDemo();
    }

    private static void testSocketChannel() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        // 设置非阻塞方式
        socketChannel.configureBlocking(false);

        // 发起连接
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 80));

        // 可能还没有真正建立连接
        while (!socketChannel.finishConnect()) {
            // 一直自旋
        }
    }

    private static void testServerSocketChannel() throws IOException {
        SelectionKey key = null;
        // 新事件到来，通过事件获取监听通道
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
        // 获取新连接的套接字通道
        SocketChannel socketChannel = serverSocketChannel.accept();
        // 设置非阻塞模式
        socketChannel.configureBlocking(false);
    }

    private static void sendDemo() throws IOException {
        String srcPath = "D:\\BaiduNetdiskDownload\\martialArt.png";
        String destFile = "socketChannel.png";

        File file = new File(srcPath);
        if (!file.exists()) {
            return;
        }
        FileChannel fileChannel = new FileInputStream(file).getChannel();

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost", 18899));

        while (!socketChannel.finishConnect()) {
            // 自旋
        }
        System.out.println("成功连接到服务器");

        ByteBuffer buffer = sendFileNameAndLength(destFile, file, socketChannel);
        int length = sendContent(file, fileChannel, socketChannel, buffer);
        if (length == -1) {
            fileChannel.close();
            socketChannel.shutdownOutput();
            socketChannel.close();
        }
        System.out.println("文件发送成功");
    }

    // 发送文件内容
    private static int sendContent(File file, FileChannel fileChannel, SocketChannel socketChannel, ByteBuffer buffer) throws IOException {
        System.out.println("开始传输文件");
        int length = 0;
        long process = 0;
        while ((length = fileChannel.read(buffer)) > 0) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
            process += length;
            System.out.println("| " + (100 * process / file.length()) + "% |");
        }

        return length;
    }

    // 发送文件名和长度
    private static ByteBuffer sendFileNameAndLength(String destFile, File file, SocketChannel socketChannel) throws IOException {
        ByteBuffer fileNameBuffer = charset.encode(destFile);

        // 发送文件名长度
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int fileNameLength = fileNameBuffer.capacity();
        byteBuffer.putInt(fileNameLength);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        byteBuffer.clear();
        System.out.println("发送文件名长度完成");

        // 发送文件名
        socketChannel.write(fileNameBuffer);
        System.out.println("发送文件名完成");

        // 发送文件长度
        byteBuffer.putLong(file.length());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        byteBuffer.clear();
        System.out.println("发送文件长度完成");

        return byteBuffer;
    }
}
