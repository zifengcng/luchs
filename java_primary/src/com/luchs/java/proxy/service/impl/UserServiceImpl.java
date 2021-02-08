package com.luchs.java.proxy.service.impl;

import com.luchs.java.proxy.service.UserService;

/**
 * @Author cheng
 * @Date 2021/2/8
 */
public class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("——————以保存——————");
    }
}
