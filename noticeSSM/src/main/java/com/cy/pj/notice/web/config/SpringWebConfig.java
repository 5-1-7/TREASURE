package com.cy.pj.notice.web.config;

import com.cy.pj.notice.web.interceptor.TimeAccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 练习  on 2021/3/12 9:16
 * 定义spring web模块配置类
 */
@Configuration
public class SpringWebConfig implements WebMvcConfigurer {
    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TimeAccessInterceptor()).addPathPatterns("/notice/*");
    }
}
