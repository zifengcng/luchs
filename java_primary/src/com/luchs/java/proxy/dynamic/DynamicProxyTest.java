package com.luchs.java.proxy.dynamic;

import com.luchs.java.proxy.service.UserService;
import com.luchs.java.proxy.service.impl.UserServiceImpl;

/**
 * @Author cheng
 * @Date 2021/2/8
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        System.out.println("原始类型：" + userService.getClass());

        DynamicProxy dynamicProxy = new DynamicProxy(userService);
        UserService proxyInstance = (UserService) dynamicProxy.getProxyInstance();
        System.out.println("代理生成的对象类型：" + proxyInstance.getClass());

        proxyInstance.save();
    }
}
