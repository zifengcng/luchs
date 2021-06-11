package com.luchs.netty.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author cheng
 * @Date 2021/5/28
 */
public class StringIntegerDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        // 可读字节小于4，消息头还没读满，return
        if (in.readableBytes() < 4) {
            return;
        }
        // 消息头已经读满
        // 在真正读取数据前，使用mark标记读取的起始下标
        in.markReaderIndex();
        int length = in.readInt();
        // 读取消息头后，readIndex读指针发生了变化
        // 如果剩余长度不够消息体，还需reset读指针，下一次从相同位置处理
        if (in.readableBytes() < length) {
            // 读指针reset到消息头的readIndex位置处
            in.resetReaderIndex();
            return;
        }
        // 读取数据
        byte[] bytes = new byte[length];
        in.readBytes(bytes, 0, length);
        out.add(new String(bytes, StandardCharsets.UTF_8));
    }
}
