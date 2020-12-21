package com.luchs.headfirst.adapter;

/**
 * @Author cheng
 * @Date 2020/12/19
 */
public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
