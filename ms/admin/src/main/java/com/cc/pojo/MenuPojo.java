package com.cc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 设计菜单pojo对象，基于此对象封装操作菜单信息<p>
 * 1.为什么不使用map去存储？
 1)可读性比较差(打开map元素不知道其内部存了什么)
 2)值的类型不可控(值的类型Object)<p>
 * 2.为什么实现Serializable接口？
 1)java规范中所有用于存储数据的对象都建议实现此接口。
 2)此接口的作用就是做标记，只有实现了接口规范的对象才可以序列化
 3)序列化的目的是将对象转换为字节存储到缓存,文件或进行网络传输<p>
 * 3.为什么要添加serialVersionUID呢？
 1)为序列化和反序列实现过程中的一个版本标识。
 2)将字节反序列化时，需要和序列化时使用的id进行对比，相同则可反序列化。<p>
 * 练习  on 2021/3/22 10:13<p>
 注解 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")<p>
 注解 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
 */
@Data
public class MenuPojo implements Serializable {
    private static final long serialVersionUID = -4602477100880547802L;

    /**菜单id(对应数据库表中的物理主键)*/
    private Integer id;

    /**菜单名称*/
    private String name;

    /**菜单url(对应要访问的资源)*/
    private String url;

    /**菜单类型(菜单，按钮)*/
    private Integer type;

    /**菜单序号，有需要可以对菜单进行排序*/
    private Integer sort;

    /**备注*/
    private String remark;

    /**上级菜单id*/
    private Integer parentId;

    /**上级菜单名称(菜单表中没有此字段)*/
    private String parentName;

    /**菜单授权标识(访问菜单时需要具备的权限)*/
    private String permission;

    /**记录创建时间*/
    private Date createdTime;

    /**记录最后一次的修改时间*/
    private Date modifiedTime;

    /**记录创建用户*/
    private String createdUser;

    /**记录修改用户*/
    private String modifiedUser;

    //需求：此记录只能由创建用户进行修改 (细粒度的权限控制)
}
