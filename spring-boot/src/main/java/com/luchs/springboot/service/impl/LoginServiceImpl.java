package com.luchs.springboot.service.impl;

import com.luchs.springboot.service.AbstractLoginService;
import org.springframework.stereotype.Service;

/**
 * @Author cheng
 * @Date 2021/9/15
 */
@Service
public class LoginServiceImpl extends AbstractLoginService {

    @Override
    public void login() {
        get();
    }
}
