package com.example.microcommon.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "redis")
@Configuration
public class RedisConfig {

    @NacosValue(value = "${host}", autoRefreshed = true)
    private String host;
    @NacosValue(value = "${port}", autoRefreshed = true)
    private Integer port;
    @NacosValue(value = "${password}", autoRefreshed = true)
    private String password;

}