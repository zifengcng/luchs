package com.luchs.headfirst.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author cheng
 * @Date 2020/12/21
 */
public class PancakeHouseIterator implements Iterator<MenuItem> {

    ArrayList<MenuItem> menuItems;
    int position = 0;

    public PancakeHouseIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.size() || menuItems.get(position) == null) {
            return false;
        }
        return true;
    }

    @Override
    public MenuItem next() {
        MenuItem item = menuItems.get(position);
        position++;
        return item;
    }
}
