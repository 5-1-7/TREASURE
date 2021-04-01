package com.cy.pj.notice.web.controller;

import com.cy.pj.notice.pojo.SysNotice;
import com.cy.pj.notice.service.SysNoticeService;
import com.cy.pj.notice.web.pojo.JsonResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 此对象为公告模块控制层处理器对象
 * 1.请求url设计
 * 1)条件查询(请求方式-Get,请求url-"/notice/")
 */
//@ResponseBody
//@Controller
@RestController
@RequestMapping("/notice/")
public class SysNoticeController {
    @Autowired
    private SysNoticeService sysNoticeService;
    /**
     * 处理客户端的查询请求
     * 不带参数的请求url：http://localhost/notice/
     * 带参数的请求url: http://localhost/notice/?type=1&title=my
     */
    @GetMapping
    public JsonResult doFindNotices(SysNotice sysNotice){

        return new JsonResult(PageHelper.startPage(1, 4)
                .doSelectPageInfo(() -> sysNoticeService.findNotices(sysNotice)));
        //这个结果会返给谁？调用方(DispatcherServlet)
        //调用方拿到方法执行结果以后会调用相关api将结果转换为json格式字符串
        //最后通过响应对象将字符串响应到客户端
    }

    /**
     *
     * @param notice 封装客户端提交的信息，一个Controller方法中只能一个参数使用@RequestBody注解，
     *               假如方法参数使用@RequestBody注解，
     *               客户端可向服务端传递Json格式的字符串参数，
     *               服务端获取字符串后以后会将Json字符串转换成参数类型的对象，
     *               这个过程可理解为Jason反序列化。
     * @return
     */
    @PostMapping
    public JsonResult doSaveNotice(@RequestBody SysNotice notice) {
        sysNoticeService.saveNotice(notice);
        return new JsonResult("save ok");
    }

    /**
     * 在方法参数中须要这个变量值时，可使用@PathVariable注解该方法参数
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public JsonResult doFindById(@PathVariable Long id) {
        return new JsonResult(sysNoticeService.findById(id));
    }

    /**
     * 更新公告信息
     * @param notice 封装了公告信息的参数对象
     * @return
     */
    @PutMapping
    public JsonResult doUpdateNotice(@RequestBody SysNotice notice) {
        sysNoticeService.updateNotice(notice);
        return new JsonResult("update ok");
    }

    @DeleteMapping("{ids}")
    public JsonResult doDeleteNotice(@PathVariable Long... ids) {
        sysNoticeService.deleteById(ids);
        return new JsonResult("delete ok");
    }
}
