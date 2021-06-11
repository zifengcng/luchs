package com.luchs.netty.decoder;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author cheng
 * @Date 2021/5/28
 */
public class IntegerProcessHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Integer data = (Integer) msg;
        System.out.println("打印出一个整数：" + data);
    }
}
