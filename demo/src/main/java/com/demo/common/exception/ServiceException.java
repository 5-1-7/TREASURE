package com.demo.common.exception;

/**
 定义业务异常对象，自己定义的异常对象，都建议：
  1)直接或间接的继承RuntimeException
  2)添加构造方法(参考父类构造方法）
 <p>
 extends RuntimeException 后 Alt+Enter构造RuntimeException 的方法
 <p>
 on 2021/3/11 16:59 */

public class ServiceException extends RuntimeException {
    /**
     * 类里一旦有含参构造，默认的无参构造就没有了，方便new所以一定要写，
     * 也可以用 lombok 注解 @NoArgsConstructor生成无参构造 */
    public ServiceException() {
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
