package com.luchs.headfirst.strategy;

/**
 * @Author cheng
 * @Date 2020/12/16
 */
public class FlyNoWays implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
