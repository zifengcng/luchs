package com.luchs.netty.protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @Author cheng
 * @Date 2021/5/31
 */
public class ProtobufDemo {

    public static void main(String[] args) {

    }

    public static MsgProtos.Msg buildMsg() {
        MsgProtos.Msg.Builder builder = MsgProtos.Msg.newBuilder();
        builder.setId(1000);
        builder.setContent("hello world!");
        return builder.build();
    }

    public static void serAndDesr1() throws Exception {
        MsgProtos.Msg msg = buildMsg();
        byte[] data = msg.toByteArray();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byteArrayOutputStream.write(data);
//        data = byteArrayOutputStream.toByteArray();

        MsgProtos.Msg msg1 = MsgProtos.Msg.parseFrom(data);
        System.out.println(msg1);
    }

    public static void serAndDesr2() throws Exception {
        MsgProtos.Msg msg = buildMsg();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        msg.writeTo(byteArrayOutputStream);
        byte[] data = byteArrayOutputStream.toByteArray();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);

        MsgProtos.Msg msg1 = MsgProtos.Msg.parseFrom(byteArrayInputStream);
        System.out.println(msg1);

    }

}
