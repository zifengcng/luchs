package com.luchs.headfirst.decorator;

/**
 * @Author cheng
 * @Date 2020/12/17
 * 饮料：装饰者模式
 */
public abstract class Beverage {

    String description = "beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
