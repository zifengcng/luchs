package com.luchs.netty.protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @Author cheng
 * @Date 2021/5/31
 */
public class ProtobufDemo {

    public static void main(String[] args) throws Exception {
        // protobuf: 17b
        serAndDesr1();
        serAndDesr2();
        serAndDesr3();

        // json: 38b
        String str = "{\"id\":1000, \"content\": \"hello world!\"}";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length);
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

    public static void serAndDesr3() throws Exception {
        MsgProtos.Msg msg = buildMsg();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        msg.writeDelimitedTo(bos);

        byte[] data = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        MsgProtos.Msg msg1 = MsgProtos.Msg.parseDelimitedFrom(bis);
        System.out.println(msg1);
    }

}
