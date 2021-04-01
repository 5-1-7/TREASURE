package com.cc.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * CheckBox用于存储复选框选项信息。<p>
 * on 2021/3/23 10:45
 */
@Data
public class CheckBox implements Serializable {

    private static final long serialVersionUID = 8494292003224009155L;

    private Integer id;
    private String name;

}
