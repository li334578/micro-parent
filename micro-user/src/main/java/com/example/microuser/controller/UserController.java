package com.example.microuser.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.microcommon.bean.Result;
import com.example.microcommon.bean.ResultMsgEnum;
import com.example.microcommon.utils.MyEncryptUtils;
import com.example.microuser.bean.User;
import com.example.microuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private Redisson redisson;

    @GetMapping("list")
    public Result<List<User>> getAllUserInfo() {
        List<User> list = userService.list();
        list.stream().map(User::toString).forEach(log::info);
        return Result.success(list);
    }

    @GetMapping("{id}")
    public Result<User> getOne(@PathVariable Long id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        User user = userService.getOne(queryWrapper);
        log.info(user.toString());
        return Result.success(user);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        if (Objects.isNull(user.getUsername()) || Objects.isNull(user.getPassword())) {
            // 账号密码不能为空
            return Result.error(ResultMsgEnum.PARAMS_NOT_NULL);
        }
        // 对密码进行 加salt MD5运算
        String encryptPassword = MyEncryptUtils.CalMd5AndSalt(user.getUsername(), user.getPassword());
        User dbUser = userService.getUserByUserName(user.getUsername());
        if (Objects.isNull(dbUser)) {
            return Result.error(ResultMsgEnum.USERNAME_NOT_FOUND);
        }
        if (!Objects.equals(dbUser.getPassword(), encryptPassword)) {
            return Result.error(ResultMsgEnum.PASSWORD_IS_WRONG);
        }
        loginUser(dbUser);
        // 返回token
        return Result.success("登录成功").setData(StpUtil.getTokenInfo());
    }

    /**
     * 将用户登录并存入Redis
     *
     * @param user 用户信息
     */
    private void loginUser(User user) {
        StpUtil.login(user.getId());
        RBucket<User> bucket = redisson.getBucket("user:" + user.getId());
        bucket.set(user, 7200, TimeUnit.SECONDS);
    }


    @GetMapping("/isLogin")
    public Result<Boolean> isLogin() {
        // 判断当前是否是登录状态 (需在header中携带token)
        return Result.success(StpUtil.isLogin());
    }
}
