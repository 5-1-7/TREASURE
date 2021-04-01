package com.cy.pj.common.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 定义分页操作工具类，在此类方法内部启动分页查询
 * 练习  on 2021/3/12 15:06
 */
public class PageUtil {
    public static <aaa> Page<aaa> startPage(){
        //3
        ServletRequestAttributes servletRequestAttributes=
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //2
        HttpServletRequest request=servletRequestAttributes.getRequest();
        String pageCurrentSrt = request.getParameter("pageCurrent");
        String pageSizeStr = request.getParameter("pageSize");
        //1
        int pageCurrent=pageCurrentSrt==null||"".equals(pageCurrentSrt)?1:Integer.parseInt(pageCurrentSrt);
        int pageSize=pageCurrentSrt==null||"".equals(pageSizeStr)?1:Integer.parseInt(pageSizeStr);
        PageHelper.startPage(pageCurrent, pageSize);
        return null;
    }
}
