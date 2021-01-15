package com.luchs.headfirst.compound.duck;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public class QuackCounter implements Quackable {

    private Quackable duck;
    private static int numberOfQuacks;
    private Observable observable;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
        notifyObservers();
    }

    public static int getNumberOfQuacks() {
        return numberOfQuacks;
    }

    @Override
    public void registryObserver(Observer observer) {
        observable.registryObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }
}
