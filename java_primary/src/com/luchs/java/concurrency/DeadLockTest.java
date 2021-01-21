package com.luchs.java.concurrency;

/**
 * @Author cheng
 * @Date 2021/1/19
 */
public class DeadLockTest {

    private static final String A = "A";
    private static final String B = "B";

    public static void main(String[] args) {
        new DeadLockTest().test();
    }

    private void test() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println(B);
                }
            }
        }, "线程A");

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println(A);
                }
            }
        }, "线程B");

        t1.start();
        t2.start();
    }

}
