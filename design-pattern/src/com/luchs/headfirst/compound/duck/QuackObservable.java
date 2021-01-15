package com.luchs.headfirst.compound.duck;

/**
 * @Author cheng
 * @Date 2021/1/12
 */
public interface QuackObservable {

    void registryObserver(Observer observer);

    void notifyObservers();
}
