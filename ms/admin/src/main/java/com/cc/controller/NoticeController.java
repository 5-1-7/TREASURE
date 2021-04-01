package com.cc.controller;

import com.cc.common.pojo.JsonResult;
import com.cc.pojo.NoticePojo;
import com.cc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 此对象为公告模块<b>控制层处理器对象</b>
 * 1.请求url,方式设计
 1)条件查询(请求方式-Get,请求url："/notice/")
 2)新增公告(请求方式-Post,请求url："/notice/")
 3)基于id查询(请求方式-Get,请求url："/notice/{id}")
 4)更新公告(请求方式-Put，请求url："/notice/")
 5)删除公告(请求方式-Delete,请求url："/notice/{id}")
 * <p>
 * 2.请求参数设计
 * 1)参数传递方式
 1.1)将请求参数通过url进行传递
 1.1.1)http://ip:port/?title=my&type=1
 1.1.2)http://ip:port/10
 1.2)请求参数通过请求体进行传递
 1.2.1) {"title":"Study Spring Boot","Content":"Study ....",....}
 * <p>
 * 1.2)服务端接收请求参数
 1.2.1)直接量(8种基本数据类型，字符串，日期)
 1.2.2)pojo对象(但是需要提供和参数名对应的set方法)
 1.2.3)map对象(前提是必须使用@RequestParam或@RequestBody注解对参数进行描述)
 * <p>
 * 1.3)方法参数描述
 1.3.1) @PathVariable 用于获取请求url中{}内部的变量
 1.3.2) @RequestBody 用于获取请求体中json格式的数据
 1.3.3) @RequestParam 用于获取非json格式的请求参数数据
 1.3.4) @DateTimeFormat 用于设置可以接收的日期格式字符串
 * <p>
 * 2.响应标准设计 ( 1)状态码 2)状态码对应的信息 3)响应数据)：JsonResult
 *
 * 练习  on 2021/3/10 19:06
 */
@RestController
@RequestMapping("/notice/")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public JsonResult findNotice(NoticePojo notice) {
        return new JsonResult(
                () -> noticeService.findNotice(notice)
        );
    }

    @GetMapping("{id}")
    public JsonResult findById(@PathVariable Long id) {
        return new JsonResult(noticeService.findNoticeById(id));
    }

    @PutMapping
    public JsonResult updateNotice(NoticePojo notice) {
        noticeService.update(notice);
        return new JsonResult("更新成功UPDATE_OK");
    }

    @PostMapping
    public JsonResult insertNotice(NoticePojo notice) {
        noticeService.insert(notice);
        return new JsonResult("新增成功INSERT_OK");
    }
}
