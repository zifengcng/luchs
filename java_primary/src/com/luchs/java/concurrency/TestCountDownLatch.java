package com.luchs.java.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author cheng
 * @Date 2021/2/2
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        new TestCountDownLatch().test();
    }

    public void test() {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            System.out.println("11111");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });

        executorService.execute(()->{
            System.out.println("22222");
            countDownLatch.countDown();
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("33333");

    }
}
