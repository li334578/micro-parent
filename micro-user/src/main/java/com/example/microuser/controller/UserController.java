package com.example.microuser.controller;

import com.example.microuser.bean.User;
import com.example.microuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserController
 * @Description 用户控制器
 * @Author Wenbo Li
 * @Date 12/9/2022 下午 12:33
 * @Version 1.0
 */
@RestController
@RequestMapping("/users/")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("list")
    public void getAllUserInfo() {
        List<User> list = userService.list();
        list.stream().map(User::toString).forEach(log::info);
    }
}
