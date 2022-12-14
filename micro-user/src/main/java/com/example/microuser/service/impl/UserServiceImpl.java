package com.example.microuser.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.microcommon.pojo.User;
import com.example.microuser.mapper.UserMapper;
import com.example.microuser.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description 用户impl类
 * @Author Wenbo Li
 * @Date 12/9/2022 下午 1:04
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getUserByUserName(String userName) {
        // 查询数据库用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userName);
        return getOne(queryWrapper);
    }
}
