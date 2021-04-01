package com.cy.pj.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class LogTests {

    private static final Logger log=
            LoggerFactory.getLogger(LogTests.class);

    @Test
    void testLogLevel(){ //trace<debug<info<error
        //将来可以通过日志级别的配置控制日志的记录
       log.trace("TRACE");
       log.debug("DEBUG");
       log.info("INFO");
       log.error("ERROR");
    }

}
