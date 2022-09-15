package com.example.microuser.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.microuser.bean.User;

/**
 * @ClassName UserService
 * @Description 用户Service
 * @Author Wenbo Li
 * @Date 12/9/2022 下午 1:04
 * @Version 1.0
 */
public interface UserService extends IService<User> {

    User getUserByUserName(String userName);
}
