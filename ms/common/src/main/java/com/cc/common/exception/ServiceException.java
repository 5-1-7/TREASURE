package com.cc.common.exception;

/**
  定义业务层统一异常处理类，基于此类封装业务层异常信息
  <p>on 2021/3/23 14:42
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 3964356681433881827L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
