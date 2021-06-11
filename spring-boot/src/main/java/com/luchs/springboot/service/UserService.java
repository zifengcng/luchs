package com.luchs.springboot.service;

import com.luchs.springboot.data.User;
import com.luchs.springboot.model.BillVipPointsLimitFindReq;

/**
 * @Author cheng
 * @Date 2020/9/22
 */
public interface UserService {

    User get(BillVipPointsLimitFindReq req);
}
