package com.luchs.springboot.service.impl;

import com.luchs.springboot.service.LoginService;
import com.luchs.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author cheng
 * @Date 2021/9/15
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @Override
    public void login() {

    }
}
