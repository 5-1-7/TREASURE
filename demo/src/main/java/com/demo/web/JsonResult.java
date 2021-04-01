package com.demo.web;

import lombok.Data;

/**
 所有的web项目，在设计响应数据时，都会有一个规范，
 比方说要响应给客户端什么数据，以什么格式进行响应。
 前端拿到Json字符串后会将字符串转换为Json格式的JS对象，然后通过对象提取数据即可。(Ajax)
 <p>
 当前Notice项目中，基于JsonResult对象封装服务端响应到客户端数据，
 对于这样的对象通常会包含三部分内容： 1)状态码 2)状态码对应的信息 3)响应数据
 * <p>
 * 练习 服务端响应到客户端的数据标准对象
 * on 2021/3/10 16:43
 */

@Data
public class JsonResult {

    /**
     * 状态码
     * 1表示Ok，0表示Exception
     * 这里可以用枚举 */
    private Integer state = 1;
    /**
     * 状态码对应的信息 */
    private String msg = "OK";
    /**
     * 响应数据，一般为查询操作结果 */
    private Object data;

    public JsonResult(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    //自定义全局异常构造方法
    public JsonResult(Throwable error) {
        this(0, error.getMessage());
    }

    public JsonResult(String msg) {
        this.msg = msg;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    /**
     * 有含参构造时无参构造就没了，所以一定要写
     */
    public JsonResult() {
    }
}
