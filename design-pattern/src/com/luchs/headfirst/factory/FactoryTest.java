package com.luchs.headfirst.factory;

/**
 * @Author cheng
 * @Date 2020/12/18
 */
public class FactoryTest {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();

        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println(pizza.getName());
    }
}
