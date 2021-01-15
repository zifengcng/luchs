package com.luchs.headfirst.compound.duck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public class Flock implements Quackable {

    private Observable observable;
    List<Quackable> quackers = new ArrayList<>();


    public Flock() {
        this.observable = new Observable(this);
    }

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = iterator.next();
            quacker.quack();
        }
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
