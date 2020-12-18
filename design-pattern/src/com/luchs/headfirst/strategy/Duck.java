package com.luchs.headfirst.strategy;

/**
 * @Author cheng
 * @Date 2020/12/16
 * 鸭子:策略模式
 */
public abstract class Duck {

    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();
    }
}
