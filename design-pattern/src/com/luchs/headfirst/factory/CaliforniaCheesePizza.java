package com.luchs.headfirst.factory;

/**
 * @Author cheng
 * @Date 2020/12/18
 */
public class CaliforniaCheesePizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;

    public CaliforniaCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        name = "CaliforniaCheesePizza";
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println("Pizza:" + name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        veggies = pizzaIngredientFactory.createVeggies();
        pepperoni = pizzaIngredientFactory.createPepperoni();
        clams = pizzaIngredientFactory.createClam();
    }
}
