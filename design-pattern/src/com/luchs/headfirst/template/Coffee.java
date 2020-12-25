package com.luchs.headfirst.template;

/**
 * @Author cheng
 * @Date 2020/12/21
 * 模板方法模式
 */
public class Coffee extends CaffeineBeverage {

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through filter");
    }
}
