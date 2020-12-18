package com.luchs.headfirst.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author cheng
 * @Date 2020/12/16
 * 天气
 */
public class WeatherData implements Observable {

    List<Observer> observers;
    private int number;

    public void setNumber(int number) {
        this.number = number;
        notifyAllObservers();
    }

    public int getNumber() {
        return number;
    }

    public WeatherData() {
        this.number = 10;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registry(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyAllObservers() {
        int number = getNumber();
        for (Observer observer : observers) {
            observer.update(number);
        }
    }
}
