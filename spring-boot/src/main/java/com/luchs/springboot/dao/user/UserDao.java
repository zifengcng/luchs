package com.luchs.springboot.dao.user;

import com.luchs.springboot.data.User;
import com.luchs.springboot.model.BillVipPointsLimitFindReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author cheng
 * @Date 2020/9/22
 */
@Mapper
//@Repository
public interface UserDao {

    @Select("select * from user where create_time between date_format(#{gmt_audit_start}, '%Y-%m-%d 00:00:00')  and date_format(#{gmt_audit_end}, '%Y-%m-%d 23:59:59')")
    User get(BillVipPointsLimitFindReq req);
}
