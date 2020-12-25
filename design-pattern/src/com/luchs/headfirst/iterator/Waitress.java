package com.luchs.headfirst.iterator;

/**
 * @Author cheng
 * @Date 2020/12/21
 */
public class Waitress {

    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}
