package com.cy.pj.notice.web.interceptor;

import com.cy.pj.common.exception.ServiceException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;

/**
 * 练习 on 2021/3/12 9:08
 * SpringWeb定义的拦截器
 */
public class TimeAccessInterceptor implements HandlerInterceptor {
    /**
     * 后端handler方法执行之前执行
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param handler  目标处理器对象
     * @return 表示是否对请求进行放行，是否继续执行后续handler方法
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        //不包含年月的时间
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        if (hour < 9 || hour > 21)
            throw new ServiceException("请在指定时间访问");
        return true;
    }
}
