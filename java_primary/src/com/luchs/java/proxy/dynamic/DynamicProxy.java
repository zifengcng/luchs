package com.luchs.java.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author cheng
 * @Date 2021/2/8
 * 动态代理：
 * 1.代理对象，不需要实现接口
 * 2.代理对象的生成，是利用JDK的API,动态的在内存中构建代理对象（目标对象为接口的类型）
 * 3.动态代理也叫做：JDK代理，接口代理
 */
public class DynamicProxy {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;

    }

    public Object getProxyInstance() {
        Class<?> targetClass = target.getClass();
        return Proxy.newProxyInstance(targetClass.getClassLoader(),
                targetClass.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("————代理前————");
                        Object invoke = method.invoke(target, args);
                        System.out.println("————代理后————");
                        return invoke;
                    }
                });
    }
}
