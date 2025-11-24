package com.luchs.java.utils;

import java.lang.reflect.Field;

/**
 * @author wbc
 * @date 2025/10/16 14:56
 */
public class SwapInt {

    public static void main(String[] args) {

        Integer a = 12;
        Integer b = 13;
        swapInt(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    public static void swapInt(Integer a, Integer b) {
        try {
            Integer t = new Integer(a);
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set(a, b);
            value.set(b, t);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
