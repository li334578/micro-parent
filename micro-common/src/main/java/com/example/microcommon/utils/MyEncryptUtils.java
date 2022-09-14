package com.example.microcommon.utils;

import cn.hutool.crypto.digest.MD5;
import com.example.microcommon.exception.ServiceException;
//import com.example.microuser.bean.User;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @Date 14/9/2022 0014 上午 10:23
 * @Description 自定义加密工具类
 * @Version 1.0.0
 * @Author liwenbo
 */
public class MyEncryptUtils {

    private static final MD5 md5 = new MD5();

    /**
     * 对密码进行加盐MD5加密
     *
     * @param salt         盐
     * @param originString 原始字符串
     * @return 加密后的字符串
     */
    public static String CalMd5AndSalt(String salt, String originString) {
        md5.setSalt(salt.getBytes(StandardCharsets.UTF_8));
        return md5.digestHex16(originString);
    }

//    /**
//     * 对用户的密码进行加盐MD5加密 username作为salt
//     *
//     * @param user 用户参数 username、password 不能为null
//     * @return 加密后的字符串
//     */
//    public static String CalMd5AndSalt(User user) {
//        if (Objects.isNull(user.getUsername()) || Objects.isNull(user.getPassword())) {
//            throw new ServiceException("账户名或密码不能为空");
//        }
//        return CalMd5AndSalt(user.getUsername(), user.getPassword());
//    }
}
