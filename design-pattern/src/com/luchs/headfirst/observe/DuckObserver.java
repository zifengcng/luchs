package com.luchs.headfirst.observe;

/**
 * @Author cheng
 * @Date 2020/12/16
 */
public class DuckObserver implements Observer, Display {

    private int number;
    private Observable observable;

    public DuckObserver(Observable observable) {
        this.number = 100;
        this.observable = observable;
        observable.registry(this);
    }

    @Override
    public void display() {
        System.out.println("DuckObserver:" + number);
    }

    @Override
    public void update(int number) {
        this.number *= number;
        display();
    }
}
