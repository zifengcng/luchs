package com.luchs.headfirst.factory;

/**
 * @Author cheng
 * @Date 2020/12/18
 */
public class NYCheesePizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public NYCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        name = "NYCheesePizza";
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Pizza:" + name);
        dough = pizzaIngredientFactory.createDough();
        cheese = pizzaIngredientFactory.createCheese();
        clams = pizzaIngredientFactory.createClam();
    }
}
