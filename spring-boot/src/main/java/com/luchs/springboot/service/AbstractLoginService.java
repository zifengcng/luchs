package com.luchs.springboot.service;

import com.luchs.springboot.model.BillVipPointsLimitFindReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author cheng
 * @Date 2020/9/22
 */
@Slf4j
@Service
public abstract class AbstractLoginService implements LoginService {

    @Autowired
    private UserService userService;

    protected void get() {
        BillVipPointsLimitFindReq req = new BillVipPointsLimitFindReq();
        userService.get(req);
    }
}
