package com.luchs.headfirst.factory;

/**
 * @Author cheng
 * @Date 2020/12/18
 */
public class NYPepperoniPizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public NYPepperoniPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        name = "NYPepperoniPizza";
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {

    }
}
