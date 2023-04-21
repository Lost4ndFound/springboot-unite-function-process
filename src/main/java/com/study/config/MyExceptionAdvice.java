package com.study.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @author: lsw
 * @date: 2023/4/20 15:25
 */
@RestControllerAdvice
public class MyExceptionAdvice {

    public MyExceptionAdvice() {
        System.out.println("MyExceptionAdvice constructor");
    }

    @ExceptionHandler(ArithmeticException.class)
    public HashMap<String,Object> arithmeticExceptionAdvice(ArithmeticException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state", -1);
        result.put("data", null);
        result.put("msg", "算出异常："+ e.getMessage());
        return result;
    }

    @ExceptionHandler(NullPointerException.class)
    public HashMap<String,Object> nullPointerExceptionAdvice(NullPointerException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state",-1);
        result.put("data",null);
        result.put("msg" , "空指针异常异常："+ e.getMessage());
        return result;
    }

    @ExceptionHandler(Exception.class)
    public HashMap<String,Object> exceptionAdvice(Exception e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("state",-1);
        result.put("data",null);
        result.put("msg" , "异常："+ e.getMessage());
        return result;
    }

}
