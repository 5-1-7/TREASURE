package com.demo.web.controller;

import com.demo.common.util.PageUtil;
import com.demo.pojo.LogPojo;
import com.demo.service.LogService;
import com.demo.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 练习  on 2021/3/18 20:16
 */

@RestController
@RequestMapping("/log/")
public class LogController {

    @Autowired
    private LogService logService;

    /*如果这里不用@Autowired 可以使用构造方法
    public LogController(LogService logService) {
        this.logService = logService;
    }*/

    @GetMapping
    public JsonResult doFindLog(LogPojo logPojo) {
        return new JsonResult(PageUtil.startPage()
                .doSelectPageInfo(
                        () -> logService.selectLog(logPojo)
                ));
    }

    @GetMapping("{id}")
    public JsonResult doFindLogById(@PathVariable Long id) {
        return new JsonResult(logService.findLogById(id));
    }

    @DeleteMapping("{ids}")
    public JsonResult doDeleteLog(@PathVariable Long... ids) {
        logService.deleteLogById(ids);
        return new JsonResult("删除成功，DeleteOk");
    }

}
