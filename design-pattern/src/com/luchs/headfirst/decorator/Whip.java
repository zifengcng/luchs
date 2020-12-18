package com.luchs.headfirst.decorator;

/**
 * @Author cheng
 * @Date 2020/12/17
 * 奶油
 */
public class Whip extends CondimentDecorator {

    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.15d;
    }
}
