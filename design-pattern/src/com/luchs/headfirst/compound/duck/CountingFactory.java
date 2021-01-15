package com.luchs.headfirst.compound.duck;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public class CountingFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new QuackCounter(new RedHeadDuck());
    }
}
