package com.luchs.netty.decoder;

import com.luchs.netty.utils.JsonUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.List;

/**
 * @Author cheng
 * @Date 2021/5/31
 */
public class JsonMsgDecoder extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String json = (String) msg;
        Object o = JsonUtils.jsonToPojo(json, Object.class);
        System.out.println(o);
    }
}
