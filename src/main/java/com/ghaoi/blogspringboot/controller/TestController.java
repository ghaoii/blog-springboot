package com.ghaoi.blogspringboot.controller;

import com.ghaoi.blogspringboot.model.UserInfo;
import com.ghaoi.blogspringboot.service.UserLogService;
import com.ghaoi.blogspringboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserService userService;

    @Resource
    private UserLogService userLogService;

    @Transactional// 开启事务
    @RequestMapping("/insert")
    public int insert() {
        UserInfo user = new UserInfo();
        user.setName("Ed");
        user.setPassword("Ed");
        return userService.add(user);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)// 开启事务
    @RequestMapping("/insert2")
    public int insert2() {
        UserInfo user = new UserInfo();
        user.setName("Dua");
        user.setPassword("Dua");
        int ret = userService.add(user);
        System.out.println("MySQL的更新行数: " + ret);
        try {
            int num = 10 / 0;// 搞个异常
        } catch (Exception e) {
            System.out.println("程序出现异常: " + e.toString());
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            ret = 0;
        }
        return ret;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping("/insert3")
    public int insert3() {
        // 1.添加用户
        UserInfo user = new UserInfo();
        user.setName("Dua");
        user.setPassword("Dua");
        int ret = userService.add(user);
        System.out.println("用户的更新行数: " + ret);
        // 添加日志
        userLogService.add("添加了用户: " + user.getName());
        return ret;
    }

    @RequestMapping("/index")
    public Map<String, Object> index() {
        Map<String, Object> map = new HashMap<>();
//        Object obj = null;
//        obj.hashCode();

        int num = 10 / 0;

        map.put("succ", 200);
        map.put("state", 1);
        map.put("msg", "ok");
        return map;
    }

    @RequestMapping("/index2")
    public UserInfo index2() {
        UserInfo user = new UserInfo();
        user.setName("Harley");
        user.setPassword("2233");
        return user;
    }

    @RequestMapping("/index3")
    public UserInfo index3() {
        UserInfo user = new UserInfo();
        user.setName("Taylor");
        user.setPassword("3344");
        return user;
    }

    @RequestMapping("/index4")
    public Map<String, Object> index4() {
        Map<String, Object> ret = new HashMap<>();
        ret.put("state", 200);
        UserInfo user = new UserInfo();
        user.setName("Lana");
        user.setPassword("1122");
        ret.put("data", user);
        return ret;
    }

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
