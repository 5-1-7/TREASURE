package com.cy.pj.notice.web.pojo;
/**
 * 所有的web项目，在设计响应数据时，都会有一个规范，比方说
 * 要响应给客户端什么数据，以什么格式进行响应。
 * 当前项目中，我们基于JsonResult对象封装服务端响应到客户端数据，
 * 对于这样的对象通常会包含三部分内容
 * 1)状态码
 * 2)消息
 * 3)数据
 */
public class JsonResult {//服务端响应到客户端的数据标准对象
    /**状态码*/
    private Integer state=1;//1表示Ok,0表示Exception
    /**状态信息*/
    private String message="OK";
    /**响应数据，一般为查询操作结果*/
    private Object data;

    public JsonResult(){}
    public JsonResult(String message) {//new JsonResult("delete ok")
        this.message = message;
    }
    public JsonResult(Object data) {//new JsonResult(list);
        this.data = data;
    }
    public JsonResult(Throwable e){//new JsonResult(exception);
        //this.state=0;
        //this.message=e.getMessage();
        this(0,e.getMessage());
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }
    //alt+insert 快速生成相关方法(set,get,toString,....)

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
