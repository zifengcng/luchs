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
public class SocketServerDemo {

    public static void main(String[] args) throws IOException {
        SocketServerDemo s = new SocketServerDemo();
        s.startServer();
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        InetSocketAddress address = new InetSocketAddress("localhost", 9000);
        serverSocket.bind(address);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] b = new byte[1024];
        int len = inputStream.read(b);
        System.out.println(new String(b, 0, len));

        accept.shutdownInput();


        OutputStream outputStream = accept.getOutputStream();
        String str = "hello world!";
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        accept.shutdownOutput();

        serverSocket.close();
    }
}
