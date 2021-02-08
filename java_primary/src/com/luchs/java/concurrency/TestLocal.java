package com.luchs.java.concurrency;

/**
 * @Author cheng
 * @Date 2021/2/5
 */
public class TestLocal {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Thread t1 = new Thread(() -> {
            threadLocal.set(1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1:" + threadLocal.get());
        }, "线程1");

        Thread t2 = new Thread(() -> {
            threadLocal.set(2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2:" + threadLocal.get());
        }, "线程2");
        t1.start();
        t2.start();

    }
}
