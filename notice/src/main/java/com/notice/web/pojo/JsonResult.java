package com.notice.web.pojo;


public class JsonResult {

    private Integer state=1;

    private String message="ok";

    private Object data;

    /**
     * 有含参构造时无参构造就没了，所以一定要写
     */
    public JsonResult() {
    }

    // 自定义全局异常构造方法，new JsonResult(exception)
    public JsonResult(Throwable e) {
        /*由：this.state=0; this.message=e.getMessage();
          简写成：this(0, e.getMessage());
          this调用的本类构造方法JsonResult(Integer state, String message)*/
        this(0, e.getMessage());
    }

    // new JsonResult(list)
    public JsonResult(Object data) {
        this.data = data;
    }

    // new JsonResult("delete ok")
    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

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
