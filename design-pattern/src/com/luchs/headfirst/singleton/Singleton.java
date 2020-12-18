package com.luchs.headfirst.singleton;

/**
 * @Author cheng
 * @Date 2020/12/18
 */
public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
