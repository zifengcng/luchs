package com.luchs.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @Author cheng
 * @Date 2021/5/18
 */
public class DatagramChannelServerDemo {

    public static void main(String[] args) throws IOException {
        startServer();
    }

    private static void startServer() throws IOException {
        DatagramChannel dChannel = DatagramChannel.open();
        dChannel.configureBlocking(false);
        dChannel.bind(new InetSocketAddress("localhost", 18899));

        Selector selector = Selector.open();
        dChannel.register(selector, SelectionKey.OP_READ);

        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isReadable()) {
                    SocketAddress socketAddress = dChannel.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(), 0, buffer.limit()));
                    buffer.clear();
                }
                iterator.remove();
            }
        }

        selector.close();
        dChannel.close();
    }
}
