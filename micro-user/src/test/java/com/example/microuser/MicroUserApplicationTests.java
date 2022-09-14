package com.example.microuser;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@Slf4j
class MicroUserApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testMethod1() {
        // 对密码进行 加salt MD5运算
        MD5 md5 = SecureUtil.md5();
        log.info("md5 HashCode is :" + md5.hashCode());
        md5.setSalt("admin".getBytes(StandardCharsets.UTF_8));
        String password1 = md5.digestHex16("123456");
        String password2 = md5.digestHex16("123456");
        log.info("md5 username is admin and password is 123456 result1 is " + password1);
        log.info("md5 username is admin and password is 123456 result2 is " + password2);
        md5.setSalt("admin".getBytes(StandardCharsets.UTF_8));
        String password3 = md5.digestHex16("654321");
        String password4 = md5.digestHex16("654321");
        log.info("md5 username is admin and password is 123456 result3 is " + password3);
        log.info("md5 username is admin and password is 123456 result4 is " + password4);
        md5 = SecureUtil.md5();
        log.info("md5 HashCode is :" + md5.hashCode());
        String password5 = md5.digestHex16("654321");
        String password6 = md5.digestHex16("654321");
        log.info("md5 username is admin and password is 123456 result5 is " + password5);
        log.info("md5 username is admin and password is 123456 result6 is " + password6);
    }
}
