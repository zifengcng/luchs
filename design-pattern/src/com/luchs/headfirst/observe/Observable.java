package com.luchs.headfirst.observe;

/**
 * @Author cheng
 * @Date 2020/12/16
 * 可观察的：观察者模式
 */
public interface Observable {

    void registry(Observer observer);
    void delete(Observer observer);
    void notifyAllObservers();
}
