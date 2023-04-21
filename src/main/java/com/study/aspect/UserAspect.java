package com.study.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: lsw
 * @date: 2023/4/20 11:35
 */
@Aspect// 当前类是一个切面
@Component
public class UserAspect {

    // 定义切点方法 Controller 包下、子孙包下所有类的所有方法
    @Pointcut("execution(* com.study.controller..*.*(..))")
    public void pointcut(){}


    // 前置通知
    @Before("pointcut()")
    public void doBefore() {}

    // 环绕通知
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        System.out.println("Around 方法开始执行");
        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            throw e;
        }
        System.out.println("Around 方法结束执行");
        return obj;
    }


}
