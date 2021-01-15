package com.luchs.headfirst.compound.duck;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public class RedHeadDuck implements Quackable {

    private Observable observable;

    public RedHeadDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("RedHeadDuck quack");
        notifyObservers();
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
