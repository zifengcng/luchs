package com.luchs.headfirst.factory;

/**
 * @Author cheng
 * @Date 2020/12/18
 */
public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza;
        if (type.equals("cheese")) {
            pizza = new ChicagoCheesePizza();
        } else if (type.equals("greek")) {
            pizza = new ChicagoGreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoPepperoniPizza();
        } else {
            pizza = new ChicagoCheesePizza();
        }
        return pizza;
    }
}
