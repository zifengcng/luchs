package com.luchs.headfirst.iterator;

import java.util.Iterator;

/**
 * @Author cheng
 * @Date 2020/12/21
 */
public class MenuItem extends MenuComponent {

    String name;
    double price;
    String description;
    // 素食的
    boolean vegetarian;

    public MenuItem(String name, double price, String description, boolean vegetarian) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.vegetarian = vegetarian;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println("," + getPrice());
        System.out.println("    -- " + getDescription());
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }
}
