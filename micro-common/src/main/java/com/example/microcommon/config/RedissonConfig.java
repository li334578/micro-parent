package com.example.microcommon.config;

import cn.hutool.core.util.StrUtil;
import com.example.microcommon.config.RedisConfig;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @ClassName RedissonUtils
 * @Description redisson工具类
 * @Author Wenbo Li
 * @Date 11/9/2022 下午 9:29
 * @Version 1.0
 */
@Configuration
public class RedissonConfig {
    private static final String redisConfTemp = "redis://{}:{}";

    @Resource
    RedisConfig redisConfig;

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        // 使用单机模式 设置地址 密码 和所用数据库
        config.useSingleServer()
//      config.useMasterSlaveServers()
//              .setMasterAddress("redis://150.230.251.14:9379")
                .setAddress(StrUtil.format(redisConfTemp, redisConfig.getHost(), redisConfig.getPort()))
                .setPassword(redisConfig.getPassword()).setConnectionMinimumIdleSize(4);
        return (Redisson) Redisson.create(config);
    }
}
