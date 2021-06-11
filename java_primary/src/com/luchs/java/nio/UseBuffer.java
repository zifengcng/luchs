package com.luchs.java.nio;

import java.nio.IntBuffer;

/**
 * @Author cheng
 * @Date 2021/5/14
 */
public class UseBuffer {

    public static void main(String[] args) {
        // 生成实例
        IntBuffer intBuffer = IntBuffer.allocate(20);
        printBuffer(intBuffer);

        // 此时读取会修改position的值，后续写入报错
//        for (int i = 0; i < 20; i++) {
//            System.out.println(intBuffer.get());
//        }

        // 实例生成之后为写入模式
        // 写入
        for (int i = 0; i < 10; i++) {
            intBuffer.put(i);
        }
        printBuffer(intBuffer);

        // 读
        // 读取之前需要翻转：从写入模式翻转到读取模式
        intBuffer.flip();
        printBuffer(intBuffer);

        for (int i = 0; i < 3; i++) {
            int num = intBuffer.get();
            System.out.println(num);
        }
        printBuffer(intBuffer);

        for (int i = 0; i < 7; i++) {
            int num = intBuffer.get();
            System.out.println(num);
        }
        printBuffer(intBuffer);

        // 重复读
        // 通过倒带方法rewind()去完成，也可以通过mark( )和reset( )两个方法组合实现

        // 超过limit会报BufferUnderflowException异常
//        System.out.println(intBuffer.get());

        // 继续写
        // 读->写：清空/压缩
        // 1清空
//        intBuffer.clear();
        // 2压缩
        intBuffer.compact();
        printBuffer(intBuffer);


    }

    private static void printBuffer(IntBuffer buffer) {
        System.out.println("position----:" + buffer.position());
        System.out.println("limit----:" + buffer.limit());
        System.out.println("capacity----:" + buffer.capacity());
    }
}
