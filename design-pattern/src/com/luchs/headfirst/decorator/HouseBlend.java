package com.luchs.headfirst.decorator;

/**
 * @Author cheng
 * @Date 2020/12/17
 * 星巴克咖啡
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend coffee";
    }

    @Override
    public double cost() {
        return 0.89d;
    }
}
