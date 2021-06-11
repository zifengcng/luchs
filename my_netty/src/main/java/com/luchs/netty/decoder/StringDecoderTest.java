package com.luchs.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @Author cheng
 * @Date 2021/5/28
 */
public class StringDecoderTest {

    public static void main(String[] args) {
        ChannelInitializer<EmbeddedChannel> i = new ChannelInitializer<EmbeddedChannel>() {
            @Override
            protected void initChannel(EmbeddedChannel ch) throws Exception {
//                ch.pipeline().addLast(new StringReplayDecoder());
                ch.pipeline().addLast(new StringIntegerDecoder());
                ch.pipeline().addLast(new StringProcessHandler());
            }
        };

        EmbeddedChannel channel = new EmbeddedChannel(i);

        String content = "你好，netty!";
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        for (int j = 0; j < 100; j++) {
            Random random = new Random();
            int r = random.nextInt(3) + 1;

            ByteBuf buffer = Unpooled.buffer();
            buffer.writeInt(bytes.length * r);
            for (int k = 0; k < r; k++) {
                buffer.writeBytes(bytes);
            }
            channel.writeInbound(buffer);
        }


    }
}
