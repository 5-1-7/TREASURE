package com.demo.web.controller;

import com.demo.common.util.PageUtil;
import com.demo.pojo.NoticePojo;
import com.demo.service.NoticeService;
import com.demo.web.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 此对象为公告模块控制层处理器对象
 <p>
1.请求url，方式设计
 1)条件查询(请求方式-Get，请求url-"/notice/")；
  2)新增公告(请求方式-Post，请求url-"/notice/")；
  3)基于id查询(请求方式-Get，请求url-"/notice/{id}")；
  4)更新公告(请求方式-Put，请求url-"/notice/")；
  5)删除公告(请求方式-Delete，请求url-"/notice/{id}")；
 <p>
 * 2.请求参数设计
 1)参数传递方式
   1.1)将请求参数通过URL进行传递
    1.1.1)http://ip:port/?title=my&type=1；
    1.1.2)http://ip:port/10；
    1.2)请求参数通过请求体进行传递: {"title":"SpringBoot","Content":"Study ....",....}
 <p>
   1.2)服务端接收请求参数
    1.2.1)直接量(8种基本数据类型，字符串，日期)；
    1.2.2)Pojo对象(但是需要提供和参数名对应的set方法)；
    1.2.3)Map对象(前提是必须使用@RequestParam或@RequestBody注解对参数进行描述)；
 <p>
   1.3)方法参数描述
    1.3.1)@PathVariable 用于获取请求URL中{}内部的变量；
    1.3.2)@RequestBody 用于获取请求体中Json格式的数据；
    1.3.3)@RequestParam 用于获取非Json格式的请求参数数据；
    1.3.4)@DateTimeFormat 用于设置可以接收的日期格式字符串；
 <p>
   2.响应标准设计(状态，消息，数据)：JsonResult
 <p> on 2021/3/10 17:13 */

@RestController
@RequestMapping("/notice/")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public JsonResult doFind(NoticePojo noticePojo) {

        //启动分页查询拦截，这里导入了自定义的一个分页的工具类
        return new JsonResult(PageUtil.startPage()
                .doSelectPageInfo(
                        ()-> noticeService.selectNotice(noticePojo)
                ));

        /*Q:这个结果返回给谁？A:底层调用方(DispatcherServlet)
              当把方法的返回值JsonResult交给DispatcherServlet后，
              他还会检测他调用的方法上面有没有@ResponseBody注解。
              这里没有@ResponseBody注解，但是类上用了@RestController
              @RestController注解的类相当于这个类上的每个方法上都有@ResponseBody注解

              调用方拿到方法执行结果以后会调用相关API将结果转换为Json格式字符串
              最后通过响应对象将字符串响应到客户端
        return new JsonResult(noticeService.selectNotice(noticePojo));

        =====================================================================
        *****写在方法上的分页语法import com.github.pagehelper.PageHelper;
        =====================================================================
        return new JsonResult(PageHelper.startPage(1, 3)
                .doSelectPageInfo(new ISelect() {
                    @Override
                    public void doSelect() {
                        noticeService.selectNotice(noticePojo);
                    }
                }));
        以上可简化成下面的Lambda表达式
        return new JsonResult(PageHelper.startPage(1, 3)
                .doSelectPageInfo(
                        () -> noticeService.selectNotice(noticePojo)));
        =====================================================================

        */
    }

    /**
     * 查询：基于id查询(请求方式-Get,请求url-"/notice/{id}")
     * <p>
     * Representational State Transfer，简称 REST。<p>
     * REST风格的URL中允许使用变量，但这个变量须使用 {}括起来
     * 当我们在方法参数中需要这个变量的值时，可以使用@PathVariable对方法参数进行描述
     * 比如访问url: http://localhost/notice/1
     */
    @GetMapping("{id}")
    public JsonResult doFindById(@PathVariable Long id){
//        try {
        return new JsonResult(noticeService.findNoticeById(id));
//        }catch (Exception e){
//            return new JsonResult(e);
//        }
    }

    /**
     * 新增公告信息
     *
     * @param noticePojo 封装客户端提交的通告信息，假如使用@RequestBody对参数进行描述，
     *                   客户端可以向服务端传递Json格式的字符串参数，服务端拿到字符串以后，
     *                   会将Json字符串转为参数类型的对象(这个过程还可以理解为Json反序列化)。
     *                   注意：一个Controller方法中只能有一个参数使用@RequestBody注解进行描述。
     */
    @PostMapping
    public JsonResult doSave(@RequestBody NoticePojo noticePojo) {
        noticeService.insertNotice(noticePojo);
        //Json序列化(将对象转换为Json格式字符串)
        return new JsonResult("SAVE_OK,新增成功");
    }

    @PutMapping
    public JsonResult doUpdate(@RequestBody NoticePojo noticePojo) {
        System.out.println("noticePojo = " + noticePojo);
        noticeService.updateNotice(noticePojo);
        return new JsonResult("UPDATE_OK,更新成功");
    }
    /**
     * 基于id执行删除业务
     */
    @DeleteMapping("{ids}")
    public JsonResult doDelete(@PathVariable Long... ids){
//       try {
        noticeService.deleteNoticeById(ids);
        return new JsonResult("DELETE_OK,删除成功");
//       }catch (Exception e){
//           return new JsonResult(e);
//       }
    }

    /* 全局异常可自定义异常工具类，比如：
      com.demo.common.exception.ServiceException
      com.demo.common.exception.DeleteException
      并将异常处理方法写入NoticeServiceImpl类

      局部异常处理方法，只能处理当前NoticeController中的RuntimeException异常：
    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return new JsonResult(e);
    }*/
}
