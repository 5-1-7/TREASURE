package com.demo.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * on 2021/3/19 14:07
 */
public class ServletUtil {

    /**
     * 通过Spring提供的RequestContextHolder对象获取请求属性对象
     */
    public static ServletRequestAttributes getServletRequestAttributes() {

        /*String className =
                RequestContextHolder.getRequestAttributes().getClass().getName();
        System.out.println("className=" + className);*/

        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

    }

    /**
     * 获取HttpServletResponse请求对象
     */
    public static HttpServletResponse getResponse() {
        return getServletRequestAttributes().getResponse();
    }

    /**
     * 获取HttpServletRequest请求对象
     */
    public static HttpServletRequest getRequest(){
        return getServletRequestAttributes().getRequest();
    }
}
