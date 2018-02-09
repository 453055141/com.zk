package com.zk.zkbootweb.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//全局异常控制器
@ControllerAdvice
public class AppWideExceptionHandler {

    //定义异常处理方法
    @ExceptionHandler(NullPointerException.class)//异常类型
    public String homeHandler(){
        return "upload";    //跳转页面
    }
}
