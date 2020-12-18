package com.luchs.headfirst.factory;

/**
 * @Author cheng
 * @Date 2020/12/18
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Veggies[] createVeggies();

    Pepperoni createPepperoni();

    Clams createClam();
}
