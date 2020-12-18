package com.luchs.headfirst.strategy;

/**
 * @Author cheng
 * @Date 2020/12/16
 */
public class MuteQuack implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("<<silence>>");
    }
}
