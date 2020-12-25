package com.luchs.headfirst.iterator;

/**
 * @Author cheng
 * @Date 2020/12/21
 */
public class MenuTestDrive {

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");

        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);

        dinerMenu.add(new MenuItem(
                "Apple Pie",
                1.59d,
                "Apple pie with a flakey crust, topped with vanilla ice cream",
                true));

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
