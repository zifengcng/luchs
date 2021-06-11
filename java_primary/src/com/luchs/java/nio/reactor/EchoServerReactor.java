package com.luchs.java.nio.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @Author cheng
 * @Date 2021/5/20
 */
public class EchoServerReactor implements Runnable {

    ServerSocketChannel serverSocketChannel;
    Selector selector;

    public EchoServerReactor() throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(new AttachHandler());
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    dispatch(selectionKey);
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dispatch(SelectionKey selectionKey) {
        Runnable handler = (Runnable) selectionKey.attachment();
        if (handler != null) {
            handler.run();
        }
    }

    class AttachHandler implements Runnable {

        @Override
        public void run() {
            try {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel != null) {
                    new EchoHandler(socketChannel, selector);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class EchoHandler implements Runnable {

        SocketChannel socketChannel;
        SelectionKey selectionKey;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        private static final int RECEIVE = 0;
        private static final int SENDING = 1;
        int state = RECEIVE;

        public EchoHandler(SocketChannel sc, Selector selector) throws IOException {
            socketChannel = sc;
            socketChannel.configureBlocking(false);
            selectionKey = socketChannel.register(selector, 0);
            selectionKey.attach(this);
            selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            selector.wakeup();
        }

        @Override
        public void run() {
            try {
                if (state == RECEIVE) {
                    int len = 0;
                    while ((len = socketChannel.read(buffer)) > 0) {
                        System.out.println(new String(buffer.array(), 0, len));
                    }
                    buffer.flip();
                    selectionKey.interestOps(SelectionKey.OP_WRITE);
                    state = SENDING;
                } else if (state == SENDING) {
                    socketChannel.write(buffer);
                    buffer.clear();
                    selectionKey.interestOps(SelectionKey.OP_READ);
                    state = RECEIVE;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
