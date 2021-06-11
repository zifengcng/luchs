package com.luchs.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author cheng
 * @Date 2021/5/28
 *
 * Head-Content协议
 */
public class StringReplayDecoder extends ReplayingDecoder<StringReplayDecoder.PHASE> {

    private Integer length;
    private byte[] bytes;

    public StringReplayDecoder() {
        super(PHASE.PHASE_1);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        switch (state()) {
            case PHASE_1:
                length = in.readInt();
                bytes = new byte[length];
                checkpoint(PHASE.PHASE_2);
                break;
            case PHASE_2:
                in.readBytes(bytes);
                String str = new String(bytes, StandardCharsets.UTF_8);
                out.add(str);
                checkpoint(PHASE.PHASE_1);
                break;
            default:
                break;
        }
    }

    public enum PHASE {
        PHASE_1,
        PHASE_2;
    }
}
