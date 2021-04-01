package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 练习 LogPojo  on 2021/3/15 21:40
 */

@Data
public class LogPojo implements Serializable {
    private static final long serialVersionUID = 7760754215820709672L;
    private Long id;
    private String ip;
    private String username;
    private String operation;
    private String method;
    private String params;
    private Long time;
    private Integer status;
    private String error;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
}
