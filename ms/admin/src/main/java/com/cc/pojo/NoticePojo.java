package com.cc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * POJO(Plain Ordinary Java Object)对象
 * 通过此类对象封装公告相关数据,例如查询结果
 * <p>
 * Java中的对象可以简单分为两大类型：
 * 1.一类是用于执行逻辑（打天下—控制逻辑，业务逻辑，数据持久逻辑）的对象
 * 2.一类是用于存储数据（守天下—POJO）的对象
 * 3.一个对象靠什么存储数据? ——属性
 * <p>on 2021/3/10 19:03*/
@Data
public class NoticePojo implements Serializable {
    private static final long serialVersionUID = -87354396734804275L;
    /** 公告 ID */
    private Long id;
    /** 公告标题 */
    private String title;
    /** 公告类型（1 通知 2 公告） */
    private String type;
    /** 公告内容 */
    private String content;
    /** 公告状态（0 正常 1 关闭） */
    private String status;
    /** 创建用户 */
    private String createdUser;
    /** 创建时间 */
    private Date createdTime;
    /** 修改用户*/
    private String modifiedUser;
    /** 修改时间*/
    private Date modifiedTime;
    /** 备注*/
    private String remark;
}
