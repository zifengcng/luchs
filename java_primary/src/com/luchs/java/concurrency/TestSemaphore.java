package com.luchs.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author cheng
 * @Date 2021/2/2
 */
public class TestSemaphore {

    public static void main(String[] args) {
        new TestSemaphore().test();
    }

    public void test() {
        Semaphore semaphore = new Semaphore(1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("11111");
            semaphore.release();
        });

        executorService.execute(()->{
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("22222");
        });

        executorService.execute(()->{
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("22222");
            semaphore.release();
        });




    }
}
