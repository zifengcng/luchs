package com.luchs.headfirst.template;

/**
 * @Author cheng
 * @Date 2020/12/21
 * 模板方法模式
 */
public class Tea extends CaffeineBeverage {

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }

    @Override
    protected void brew() {
        System.out.println("Dripping Tea through filter");
    }
}
