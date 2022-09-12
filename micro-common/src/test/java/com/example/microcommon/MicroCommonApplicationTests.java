package com.example.microcommon;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class MicroCommonApplicationTests {

    @Resource
    private Redisson redisson;

    @Test
    void contextLoads() {
    }

    @Test
    public void testMethod1() {
        RBucket<String> bucketLock = redisson.getBucket("lock");
        bucketLock.set("wuhu");
        String value = bucketLock.get();
        log.info(value);
    }

}
