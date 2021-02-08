package com.luchs.java.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author cheng
 * @Date 2021/2/8
 * Cglib代理：也叫做子类代理，它是在内存中构建一个子类对象从而实现对目标对象的扩展
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("—————代理前—————");
        Object invoke = method.invoke(target, objects);
        System.out.println("—————代理后—————");
        return invoke;
    }
}
