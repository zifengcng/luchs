package com.luchs.headfirst.compound.duck;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public class Quackologist implements Observer {

    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist：" + duck + " just quacked.");
    }
}
