package com.luchs.headfirst.adapter;

/**
 * @Author cheng
 * @Date 2020/12/19
 */
public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("gobble");
    }

    @Override
    public void fly() {
        System.out.println("fly a short distance");
    }
}
