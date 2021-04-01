package com.demo.common.exception;

import lombok.NoArgsConstructor;

/**
 定义业务中删除操作的异常对象，自己定义的异常对象
 <p>
 extends RuntimeException 后 Alt+Enter构造 ServiceException 方法
<p> 练习  on 2021/3/11 17:03 */

@NoArgsConstructor
public class DeleteException extends ServiceException {
    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    protected DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
