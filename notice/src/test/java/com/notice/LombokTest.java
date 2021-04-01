package com.notice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 练习 @Slf4j注解
 * on 2021/3/15 10:20
 */
@Slf4j
@SpringBootTest
public class LombokTest {

    @Test
    void testLombok() {
        log.debug("测试lombok log");
    }
}
