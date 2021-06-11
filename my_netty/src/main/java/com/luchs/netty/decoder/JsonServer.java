package com.luchs.netty.decoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.json.JsonObjectDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @Author cheng
 * @Date 2021/5/31
 */
public class JsonServer {

    public static void main(String[] args) {
        new JsonServer().runServer();
    }

    private void runServer() {
        EventLoopGroup bg = new NioEventLoopGroup(1);
        EventLoopGroup wg = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(bg, wg);
        b.channel(NioServerSocketChannel.class);
        b.bind(8080);
        b.option(ChannelOption.SO_KEEPALIVE, true);
        b.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 4));
                ch.pipeline().addLast(new StringDecoder());
                ch.pipeline().addLast(new JsonMsgDecoder());
            }
        });

    }
}
