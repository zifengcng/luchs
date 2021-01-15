package com.luchs.headfirst.compound.duck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public class Observable implements QuackObservable {

    private List<Observer> observers = new ArrayList<>();

    private QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registryObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer observer = iterator.next();
            observer.update(duck);
        }
    }
}
