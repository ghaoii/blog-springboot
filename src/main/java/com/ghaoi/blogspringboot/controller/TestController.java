package com.ghaoi.blogspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/art")
public class TestController {

    /**
     * 请求转发
     * @return
     */
    @RequestMapping("/edit")
    public String forward() {
        System.out.println("进行了请求转发");
        // 假设现在没有登录
        return "forward:/login.html";
    }

    /**
     * 请求重定向
     * @return
     */
    @RequestMapping("/edit2")
    public String redirect() {
        System.out.println("进行了请求重定向");
        return "redirect:/login.html";
    }
}
