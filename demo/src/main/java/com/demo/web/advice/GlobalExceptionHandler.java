package com.demo.web.advice;

import com.demo.common.exception.ServiceException;
import com.demo.web.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
  注解 @RestControllerAdvice描述的类为SpringWeb模块定义的全局异常处理类。
  当我们在注解 @RestController/@Controller描述的类或父类中没有处理异常，
  则系统会查找@RestControllerAdvice注解描述的全局异常处理类，
  可以通过此类中的异常处理方法对异常进行处理。<p>
注解 @RestControllerAdvice==@ControllerAdvice+@ResponseBody
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    public static final Logger log
            = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 注解 @ExceptionHandler 描述的方法为异常处理方法，
     * 此注解中定义的异常类型为此方法可以处理的异常类型（包含这个异常类型的子类类型）
     * @param e 此参数用于接收要处理的异常对象，通常会与 @ExceptionHandler注解中定义的异常类型相同，
     *           或者是@ExceptionHandler 注解中定义异常类型的父类类型。
     * @return 封装了异常状态和信息的对象 */
    /*@ExceptionHandler(ServiceException.class)
    public JsonResult doHandleServiceException(ServiceException e) {
        e.printStackTrace();
        log.error("exception {}", e.getMessage());
        return new JsonResult(e);
    }*/

    @ExceptionHandler
    public JsonResult doHandleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        log.error("Exception: {}", e.getMessage());
        return new JsonResult(e);
    }

    @ExceptionHandler(NumberFormatException.class)
    public JsonResult doHandleNumberFormatException(NumberFormatException nfe) {
        nfe.printStackTrace();
        log.error("Exception: {}", "传入参数值类型不匹配");

        /*return new JsonResult(nfe);

        JsonResult r = new JsonResult();
        r.setState(0);
        r.setMsg("传入参数值类型不匹配");
        return r;*/
        return new JsonResult(0,"传入参数值类型不匹配");
    }
}
