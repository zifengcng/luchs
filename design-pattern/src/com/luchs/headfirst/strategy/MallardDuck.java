package com.luchs.headfirst.strategy;

/**
 * @Author cheng
 * @Date 2020/12/16
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        this.flyBehaviour = new FlyWithWings();
        this.quackBehaviour = new Quack();
    }
}
