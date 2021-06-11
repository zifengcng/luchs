package com.luchs.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author cheng
 * @Date 2021/5/25
 */
public class NettyDiscardServer {

    private final int serverPort;
    ServerBootstrap b = new ServerBootstrap();

    public NettyDiscardServer(int serverPort) {
        this.serverPort = serverPort;
    }

    public void startServer() {
        // 创建反应器轮询组
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerLoopGroup = new NioEventLoopGroup();

        try {
            // 1.设置反应器轮询组
            b.group(bossLoopGroup, workerLoopGroup);
            // 2.设置nio类型的通道
            b.channel(NioServerSocketChannel.class);
            // 3.设置监听端口
            b.localAddress(serverPort);
            // 4.设置通道的参数
            b.option(ChannelOption.SO_KEEPALIVE, true);
            // 5.装配子通道流水线
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                // 有连接到达时会创建一个通道
                @Override
                protected void initChannel(SocketChannel ch) {
                    // 流水线的职责：负责管理通道中的handler处理器
                    // 向子通道（传输通道）流水线添加一个handler处理器
                    ch.pipeline().addLast(new NettyDiscardHandler());
                }
            });
            // 6.绑定服务器
            // 调用sync同步方法阻塞直到绑定成功
            ChannelFuture channelFuture = b.bind().sync();
            // 7.等待通道关闭的异步任务结束
            // 服务监听通道会一直等待通道关闭的异步任务结束
            ChannelFuture closeFuture = channelFuture.channel().closeFuture();
            closeFuture.sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerLoopGroup.shutdownGracefully();
            bossLoopGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        new NettyDiscardServer(8080).startServer();
    }
}
