package com.ghaoi.blogspringboot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice// 1.表示为控制器增强类
@ResponseBody
public class ErrorAdvice {
    // 2.添加异常统一处理方法
    @ExceptionHandler(NullPointerException.class)
    public Map<String, Object> nullException(NullPointerException e) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("succ", 200);// 表示本次请求成功
        ret.put("state", -1);// 报错
        ret.put("msg", "空指针异常，请稍后再试");
        return ret;
    }

    @ExceptionHandler(Exception.class)
    public Map<String, Object> exception(Exception e) {
        Map<String, Object> ret = new HashMap<>();
        ret.put("succ", 200);// 表示本次请求成功
        ret.put("state", -1);// 报错
        ret.put("msg", "出现异常，请稍后再试");
        return ret;
    }
}
