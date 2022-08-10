package com.ghaoi.blogspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public Object login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("succ", 200);// 后端响应状态码
        String msg = "";
        int state = -1;// 登录状态码
        if(username != null && password != null &&
                username.equals("admin") && password.equals("admin")) {
            // 登录成功
            state = 1;
        }else {
            // 登录失败
            msg = "用户名或密码输入有误!请检查!";
        }
        map.put("state", state);
        map.put("msg", msg);
        return map;
    }
}
