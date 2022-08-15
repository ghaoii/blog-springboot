package com.ghaoi.blogspringboot.config;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一数据格式处理
 */
@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {
    // 是否要进行内容重写，默认为false，也就是不进行内容的重写
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        // 统一数据格式的封装
        Map<String, Object> ret = new HashMap<>();
        ret.put("succ", 200);// 返回大状态
        ret.put("state", 1);// 实际上这个小状态并不好定义，一般程序员都把小状态放在body中，我们这里就简单写个1
        ret.put("data", body);
        return ret;
    }
}
