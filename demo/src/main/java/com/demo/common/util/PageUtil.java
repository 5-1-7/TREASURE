package com.demo.common.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义分页操作工具类，，在此类方法内部启动分页查询
 * on 2021/3/19 14:11
 */

public class PageUtil {
    public static <T> Page<T> startPage() {

        /*//获取请求对象
        ServletRequestAttributes sra =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();*/

        HttpServletRequest request = ServletUtil.getRequest();

        //获取请求中的分页参数对象
        String pageCurrentStr = request.getParameter("pageCurrent");
        String pageSizeStr = request.getParameter("pageSize");

        int pageCurrent = StringUtil.isEmpty(pageCurrentStr) ? 1 : Integer.parseInt(pageCurrentStr);
        int pageSize = StringUtil.isEmpty(pageSizeStr) ? 10 : Integer.parseInt(pageSizeStr);

        //启动分页查询
        return PageHelper.startPage(pageCurrent, pageSize);

    }
}
