package com.luchs.headfirst.adapter;

/**
 * @Author cheng
 * @Date 2020/12/19
 */
public class DuckTest {

    public static void main(String[] args) {
        Duck turkeyAdapter = new TurkeyAdapter(new WildTurkey());
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
