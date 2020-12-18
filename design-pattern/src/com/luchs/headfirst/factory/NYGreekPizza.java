package com.luchs.headfirst.factory;

/**
 * @Author cheng
 * @Date 2020/12/18
 */
public class NYGreekPizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public NYGreekPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        name = "NYGreekPizza";
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }


    @Override
    void prepare() {

    }
}
