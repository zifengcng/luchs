package com.luchs.headfirst.factory;

/**
 * @Author cheng
 * @Date 2020/12/18
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        Pizza pizza;
        if (type.equals("cheese")) {
            pizza = new NYCheesePizza(pizzaIngredientFactory);
        } else if (type.equals("greek")) {
            pizza = new NYGreekPizza(pizzaIngredientFactory);
        } else if (type.equals("pepperoni")) {
            pizza = new NYPepperoniPizza(pizzaIngredientFactory);
        } else {
            pizza = new NYCheesePizza(pizzaIngredientFactory);
        }
        return pizza;
    }
}
