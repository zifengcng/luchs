package com.luchs.java.proxy.sta;

import com.luchs.java.proxy.service.UserService;

/**
 * @Author cheng
 * @Date 2021/2/8
 * 静态代理
 */
public class StaticProxy {

    private UserService userService;

    public StaticProxy(UserService userService) {
        this.userService = userService;
    }

    public void save() {
        System.out.println("————代理前————");
        userService.save();
        System.out.println("————代理后————");
    }
}
