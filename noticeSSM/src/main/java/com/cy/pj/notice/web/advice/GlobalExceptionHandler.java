package com.cy.pj.notice.web.advice;

import com.cy.pj.notice.web.pojo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 练习自定义全局异常  on 2021/3/11 17:17
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    public static final Logger LOGGER =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandlerRuntimeException(RuntimeException e) {
        e.printStackTrace();
        LOGGER.error("exception message is {}",e.getMessage());
        return new JsonResult(e);
    }
}
