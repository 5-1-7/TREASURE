package com.cc.common.pojo;

import com.cc.common.util.PageUtil;
import com.github.pagehelper.ISelect;
import lombok.Data;

import java.io.Serializable;

/**
 * 所有的web项目，在设计响应数据时，都会有一个规范，
 * 比方说要响应给客户端什么数据，以什么格式进行响应。
 * 前端拿到Json字符串后会将字符串转换为Json格式的JS对象，然后通过对象提取数据即可。(Ajax)
 * <p>
 * 当前Notice项目中，基于JsonResult对象封装服务端响应到客户端数据，
 * 对于这样的对象通常会包含三部分内容： 1)状态码 2)状态码对应的信息 3)响应数据
 * <p>
 * 练习 服务端响应到客户端的数据标准对象
 * on 2021/3/10 16:43
 */
@Data
public class JsonResult implements Serializable {
    private static final long serialVersionUID = -4195864053125689617L;

    /**
     * 状态码
     * 1表示Ok，0表示Exception
     * 这里可以用枚举 */
    private Integer state = 1;
    /**
     * 状态码对应的信息 */
    private String msg = "OK-자바";
    /**
     * 响应数据，一般为查询操作结果 */
    private Object data;

    public JsonResult() {}

    public JsonResult(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public JsonResult(String msg) {
        this.msg = msg;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    //自定义全局异常构造方法
    public JsonResult(Throwable e) {
        this(0, e.getMessage());
    }

    /**
     * 基于pagehelper自定义分页工具类的构造方法，
     * 方便需要分页的地方直接new触发方法。
     * @param select
     */
    public JsonResult(ISelect select) {
        this.data = PageUtil.startPage().doSelectPageInfo(select);
    }
}

