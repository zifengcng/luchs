package com.luchs.java.primary;

/**
 * @Author cheng
 * @Date 2020/9/23
 */
public class TestFinal {

    private int num = 0;

    public static void main(String[] args) {
        TestFinal t = new TestFinal();
        System.out.println(t.num);
        System.out.println(t.add());
        System.out.println(t.num);
    }

    public int add() {
        try {
            num++;
            return num;
        } finally {
            num++;
            return 0;
        }
    }

}
