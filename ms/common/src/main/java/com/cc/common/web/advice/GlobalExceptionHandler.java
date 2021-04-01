package com.cc.common.web.advice;

import com.cc.common.pojo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
定义统一异常处理对象
 <p>on 2021/3/22 15:38
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        log.error("Exception{}", e.getMessage());
        return new JsonResult(e);
    }
}
