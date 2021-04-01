package com.cc.common.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import javax.servlet.http.HttpServletRequest;

/**
自定义分页操作工具类，在此类方法内部启动分页查询，
 在项目中去添加一个 PageHelper 依赖(后缀是 starter 的)
<p>on 2021/3/19 14:11
 */
public class PageUtil {
    /**
     * 通过此方法启动分页查询
     * @param <T>这里的 T 为泛型
     *           返回值类型左侧有<T>这种符号的表示方法为泛型方法
     * @return
     */
    public static <T> Page<T> startPage() {

        /*获取请求对象
        ServletRequestAttributes sra =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();*/
        HttpServletRequest request = ServletUtil.getRequest();

        //获取当前页码值(要查第几页的数据)
        String pageCurrentStr = request.getParameter("pageCurrent");
        //获取页面大小(每页最多显示多少条记录)
        String pageSizeStr = request.getParameter("pageSize");

        //将获取的字符串转换为整数,在此位置调用 PageHelper 中的一个方法启动分页
        Integer pageCurrent = StringUtil.isEmpty(pageCurrentStr) ? 1 : Integer.parseInt(pageCurrentStr);
        Integer pageSize = StringUtil.isEmpty(pageSizeStr) ? 5 : Integer.parseInt(pageSizeStr);

        //启动分页查询,启动 PageHelper 中的分页拦截器(PageInterceptor)
        return PageHelper.startPage(pageCurrent, pageSize);

    }
}
