package com.luchs.headfirst.iterator;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Author cheng
 * @Date 2020/12/21
 */
public class CompositeIterator implements Iterator<MenuComponent> {

    private Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<MenuComponent> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent next = iterator.next();

            if (next instanceof Menu) {
                stack.push(next.createIterator());
            }
            return next;
        } else {
            return null;
        }
    }
}
