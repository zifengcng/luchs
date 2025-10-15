//package com.luchs.netty;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelFutureListener;
//import io.netty.channel.ChannelHandler;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInboundHandlerAdapter;
//
//import java.nio.charset.StandardCharsets;
//
///**
// * @Author cheng
// * @Date 2021/5/27
// */
//@ChannelHandler.Sharable
//public class NettyEchoServerHandler extends ChannelInboundHandlerAdapter {
//
//    public static final NettyEchoServerHandler INSTANCE = new NettyEchoServerHandler();
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
////        super.channelRead(ctx, msg);
//
//        ByteBuf in = (ByteBuf) msg;
//        System.out.println("msg type:" + (in.hasArray() ? "堆内存" : "直接内存"));
//        int len = in.readableBytes();
//        byte[] bytes = new byte[len];
//        in.getBytes(0, bytes);
//        System.out.println("收到内容：" + new String(bytes, StandardCharsets.UTF_8));
//
//        ChannelFuture channelFuture = ctx.writeAndFlush(msg);
//        channelFuture.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) throws Exception {
//                System.out.println("写回后，refCnt:" + in.refCnt());
//            }
//        });
//    }
//}
