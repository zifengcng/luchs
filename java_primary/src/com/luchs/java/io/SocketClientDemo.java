package com.luchs.java.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author cheng
 * @Date 2021/5/12
 */
public class SocketClientDemo {

    public static void main(String[] args) throws IOException {
        SocketClientDemo s = new SocketClientDemo();
        s.startClient();
    }

    public void startClient() throws IOException {
        Socket socket = new Socket("localhost", 9000);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("客户端发送数据".getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = inputStream.read(b);
        System.out.println(new String(b, 0, len));
        socket.shutdownInput();

        socket.close();
    }
}
