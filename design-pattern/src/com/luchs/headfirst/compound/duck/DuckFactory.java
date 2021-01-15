package com.luchs.headfirst.compound.duck;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public class DuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }
}
