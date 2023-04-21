package com.study.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: lsw
 * @date: 2023/4/20 14:21
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    // 返回 true 表示拦截判断通过，可以访问后面的接口
    // 返回 false 表示拦截未通过，直接返回结果给前端
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("登录拦截器");
        // 1.得到 HttpSession 对象
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userinfo") != null) {
            // 表示已经登录
            return true;
        }
        // 执行到此代码表示未登录，未登录就跳转到登录页面
        response.sendRedirect("/login.html");
        return false;
    }
}
