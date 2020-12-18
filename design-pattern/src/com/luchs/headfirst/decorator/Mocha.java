package com.luchs.headfirst.decorator;

/**
 * @Author cheng
 * @Date 2020/12/17
 * 摩卡
 */
public class Mocha extends CondimentDecorator {

    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.2d;
    }
}
