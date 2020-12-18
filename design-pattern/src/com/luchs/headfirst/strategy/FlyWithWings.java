package com.luchs.headfirst.strategy;

/**
 * @Author cheng
 * @Date 2020/12/16
 */
public class FlyWithWings implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
