package com.luchs.headfirst.decorator;

/**
 * @Author cheng
 * @Date 2020/12/17
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "  $:" + beverage.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Soy(houseBlend);
        houseBlend = new Whip(houseBlend);

        System.out.println(houseBlend.getDescription() + "  $:" + houseBlend.cost());
    }
}
