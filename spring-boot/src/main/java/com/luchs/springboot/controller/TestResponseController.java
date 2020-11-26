package com.luchs.springboot.controller;

import com.luchs.springboot.data.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cheng
 * @Date 2020/9/22
 */

@RestController
@RequestMapping("/test")
public class TestResponseController {

    @GetMapping("/test1")
    public User test1() {
        return new User(">=");
    }
}
