package com.common.exception;

/**
 * 定义业务中删除操作的异常对象，自己定义的异常对象
 * <p>
 * 练习  on 2021/3/12 21:57
 */
public class DeleteException extends ServiceException {
    public DeleteException() {
        super();
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
