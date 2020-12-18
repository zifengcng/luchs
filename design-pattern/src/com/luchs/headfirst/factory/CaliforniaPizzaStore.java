package com.luchs.headfirst.factory;

/**
 * @Author cheng
 * @Date 2020/12/18
 */
public class CaliforniaPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza;
        if (type.equals("cheese")) {
            pizza = new CaliforniaCheesePizza(null);
        } else if (type.equals("greek")) {
            pizza = new CaliforniaGreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new CaliforniaPepperoniPizza();
        } else {
            pizza = new CaliforniaCheesePizza(null);
        }
        return pizza;
    }
}
