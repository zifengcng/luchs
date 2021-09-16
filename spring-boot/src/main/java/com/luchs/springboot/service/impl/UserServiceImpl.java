package com.luchs.springboot.service.impl;

import com.luchs.springboot.dao.user.UserDao;
import com.luchs.springboot.data.User;
import com.luchs.springboot.model.BillVipPointsLimitFindReq;
import com.luchs.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author cheng
 * @Date 2020/9/22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User get(BillVipPointsLimitFindReq req) {
        return userDao.get(req);
    }

}
