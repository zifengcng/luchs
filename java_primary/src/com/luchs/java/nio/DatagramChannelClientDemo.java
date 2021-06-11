package com.luchs.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @Author cheng
 * @Date 2021/5/18
 */
public class DatagramChannelClientDemo {

    public static void main(String[] args) throws IOException {
        startClient();
    }

    private static void startClient() throws IOException {
        DatagramChannel dChannel = DatagramChannel.open();
        dChannel.configureBlocking(false);

        // 可以监听
//        dChannel.socket().bind(new InetSocketAddress("127.0.0.1", 9090));

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Scanner scanner = new Scanner(System.in);
        System.out.println("客服端启动成功");
        System.out.println("请输入内容：");
        while (scanner.hasNext()) {
            String time = LocalDateTime.now().toString();
            System.out.println(time);
            String next = scanner.next();
            buffer.put((time + "》》》" + next).getBytes(StandardCharsets.UTF_8));
            buffer.flip();
            dChannel.send(buffer, new InetSocketAddress("localhost", 18899));
            buffer.clear();
        }

        dChannel.close();
    }
}
