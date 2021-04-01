package com.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * POJO(Plain Ordinary Java Object)对象
 * 通过此类对象封装相关数据，例如查询结果
 * <p>
 * Java中的对象可以简单分为两大类型：
 * 1.一类是用于执行逻辑（打天下—控制逻辑，业务逻辑，数据持久逻辑）的对象；
 * 2.一类是用于存储数据（守天下—POJO）的对象；
 * 3.一个对象靠什么存储数据? ——属性；
 * <p>
 * 练习 POJO on 2021/3/8 17:45
 */

@Data
public class NoticePojo implements Serializable {
    private static final long serialVersionUID = -1657815991260896323L;
    /**
     * 公告 ID
     */
    private Long id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告类型（1 通知 2 公告）
     */
    private String type;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 公告状态（0 正常 1 关闭）
     */
    private String status;
    /**
     * 备注
     */
    private String remark;

    /**
     * 注解 @DateTimeFormat 用于描述属性或set方法，用于告诉spring web模块，在将
     * 日期字符串转换为日期对象时，按照此注解中pattern属性设置的格式进行转换。
     * <p>
     * 注解 @JsonFormat 描述属性或get方法时，用于告诉底层API，在将对象转换为Json字符串时，
     * 按照此注解中 pattern 属性指定的日期格式进行转换，其中 timezone 用于指定时区。
     * <p>
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifiedTime;
    /**
     * 创建用户
     */
    private String createdUser;
    /**
     * 修改用户
     */
    private String modifiedUser;
}
