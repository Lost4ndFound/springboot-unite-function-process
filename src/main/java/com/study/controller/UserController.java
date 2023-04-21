package com.study.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: lsw
 * @date: 2023/4/20 11:15
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("a1")
    public Boolean login(HttpServletRequest request){
        // 有 Session 就获取，没有就不创建
        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("userinfo") != null){
            // 说明已经登陆，进行业务处理
            return true;
        } else {
            // 未登录
            return false;
        }
    }

    @RequestMapping("/a2")
    public Boolean login2 (HttpServletRequest request) {
        // 有 Session 就获取，没有就不创建
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("userinfo") != null) {
            // 说明已经登录，进行业务处理
            return true;
        } else {
            // 未登录
            return false;
        }
    }

    @RequestMapping("/login")
    public boolean login(HttpServletRequest request,String username, String password) {
        boolean result = false;
        if (StringUtils.hasLength(username) && StringUtils.hasLength(password)) {
            if(username.equals("admin") && password.equals("admin")) {
                HttpSession session = request.getSession();
                session.setAttribute("userinfo","userinfo");
                return true;
            }
        }
        return result;
    }

    @RequestMapping("/index")
    public String index() {
        return "Hello Index";
    }

    @RequestMapping("/indexException")
    public String indexException() {
        int num = 10/0;
        return "Hello Index";
    }

    @RequestMapping("/reg")
    public int reg() {
        return 1;
    }

}
