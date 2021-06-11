package com.luchs.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.socket.SocketChannel;

import javax.net.ssl.SSLEngine;

/**
 * @Author cheng
 * @Date 2021/5/28
 */
public class Byte2IntegerDecoderTest {

    public static void main(String[] args) {
        ChannelInitializer<EmbeddedChannel> i = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) throws Exception {
                ch.pipeline().addLast(new Byte2IntegerDecoder());
                ch.pipeline().addLast(new IntegerProcessHandler());
            }
        };
        EmbeddedChannel channel = new EmbeddedChannel(i);
        for (int j = 0; j < 100; j++) {
            ByteBuf buffer = Unpooled.buffer();
            buffer.writeInt(j);
            channel.writeInbound(buffer);
        }
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
