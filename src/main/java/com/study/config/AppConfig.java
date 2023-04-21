package com.study.config;

import com.study.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author: lsw
 * @date: 2023/4/20 14:25
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //        registry.addInterceptor(new LoginIntercept());//可以直接new 也可以属性注入
        registry.addInterceptor(loginInterceptor).
                addPathPatterns("/**").// 拦截所有 url
                excludePathPatterns("/user/login"). //不拦截登录注册接口
                excludePathPatterns("/user/reg").
                excludePathPatterns("/api/user/login").
                excludePathPatterns("/login.html").
                excludePathPatterns("/reg.html").
                excludePathPatterns("/**/*.js").
                excludePathPatterns("/**/*.css").
                excludePathPatterns("/**/*.png").
                excludePathPatterns("/**/*.jpg");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("api", c -> true);
    }
}
