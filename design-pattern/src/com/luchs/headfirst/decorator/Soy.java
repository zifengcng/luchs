package com.luchs.headfirst.decorator;

/**
 * @Author cheng
 * @Date 2020/12/17
 * 豆浆
 */
public class Soy extends CondimentDecorator {

    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.1d;
    }
}
