package com.luchs.java.proxy.cglib;

import com.luchs.java.proxy.service.impl.UserServiceImpl;

/**
 * @Author cheng
 * @Date 2021/2/8
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        System.out.println("原始的类型：" + userServiceImpl.getClass());

        CglibProxy cglibProxy = new CglibProxy(userServiceImpl);
        UserServiceImpl proxyInstance = (UserServiceImpl) cglibProxy.getProxyInstance();
        System.out.println("生成的代理对象类型：" + proxyInstance.getClass());

        proxyInstance.save();

    }
}
