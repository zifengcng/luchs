package com.luchs.headfirst.template;

/**
 * @Author cheng
 * @Date 2020/12/21
 */
public abstract class AbstractClass {

    final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }

    // 钩子
    void hook() {

    }

    final void concreteOperation() {
        // ...
    }

    protected abstract void primitiveOperation2();

    abstract void primitiveOperation1();
}
