package com.notice.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 练习日志测试
 * on 2021/3/13 12:56
 */
@SpringBootTest
public class LogTest {
    // 哪个类写日志就要将那个类名写入getLogger的参数
    // 比如LoggerFactory.getLogger(LogTest.class)
    private static final Logger LOG =
            LoggerFactory.getLogger(LogTest.class);

    @Test
    void LoggerTest(){

        // 将来可以通过日志级别的配置控制日志的记录
        // 在文件application.properties中配置logging.level.com.notice=debug
        // 日志级别：trace<debug<info<error
        LOG.trace("TRACE");
        LOG.debug("DEBUG");
        LOG.info("INFO");
        LOG.error("ERROR");
    }
}
