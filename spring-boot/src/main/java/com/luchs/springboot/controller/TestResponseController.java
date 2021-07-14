package com.luchs.springboot.controller;

import com.luchs.springboot.data.User;
import com.luchs.springboot.model.BillVipPointsLimitFindReq;
import com.luchs.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author cheng
 * @Date 2020/9/22
 */

@RestController
@RequestMapping("/test")
public class TestResponseController {

    @Autowired
    private UserService userService;

    @PostMapping("/test1")
    public User test1(@RequestBody BillVipPointsLimitFindReq req) {
        return userService.get(req);
    }

    @GetMapping("/redirect")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.baidu.com/");
    }

    @PostMapping(value = "/test2", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public User test2(@RequestBody MultiValueMap<String, String> req) {
        System.out.println(req);
        User user = new User();
        user.setName("张三");
        return user;
    }

    @GetMapping("/stress")
    public String stressTest() {
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "请求成功";
    }


}
