package com.example.microuser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.microuser.bean.User;
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
}
