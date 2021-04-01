package com.cc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 定义角色领域对象RolePojo，用于封装角色自身信息
 <p>on 2021/3/23 10:24
 */
@Data
public class RolePojo implements Serializable {

    private static final long serialVersionUID = 3864896668845996191L;

    /**角色 id*/
    private Integer id;
    /**角色名称*/
    private String name;
    /**菜单 id(基于角色id查询到的或者添加、更新时传入的)*/
    private List<Integer> menuIds;
    /**备注*/
    private String remark;
    /**创建时间*/
    private Date createdTime;
    /**修改时间*/
    private Date modifiedTime;
    /**创建用户*/
    private String createdUser;
    /**修改用户*/
    private String modifiedUser;

}
