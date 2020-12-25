package com.luchs.headfirst.state;

/**
 * @Author cheng
 * @Date 2020/12/22
 */
public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
