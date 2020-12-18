package com.luchs.headfirst.observe;

/**
 * @Author cheng
 * @Date 2020/12/16
 */
public class CurrObserver implements Observer, Display {

    private int number;
    private Observable observable;

    public CurrObserver(Observable observable) {
        this.number = 10;
        this.observable = observable;
        observable.registry(this);
    }

    @Override
    public void update(int number) {
        this.number += number;
        display();
    }

    @Override
    public void display() {
        System.out.println("CurrObserver:" + number);
    }
}
