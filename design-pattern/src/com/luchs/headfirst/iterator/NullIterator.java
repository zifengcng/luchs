package com.luchs.headfirst.iterator;

import java.util.Iterator;

/**
 * @Author cheng
 * @Date 2020/12/21
 */
public class NullIterator implements Iterator<MenuComponent> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }
}
