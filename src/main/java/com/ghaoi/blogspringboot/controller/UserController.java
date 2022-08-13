package com.ghaoi.blogspringboot.controller;

import com.ghaoi.blogspringboot.model.UserInfo;
import com.ghaoi.blogspringboot.service.UserService;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有用户的信息
     * @return
     */
    @RequestMapping("/getall")
    public List<UserInfo> getAll() {
        return userService.getAll();
    }

    @RequestMapping("/getall2")
    public List<UserInfo> getAll2(String order) {
        return userService.getAll2(order);
    }

    @RequestMapping("/add")
    public int add(UserInfo userInfo) {
        // 参数校验 -> 调用Service层
        if(userInfo == null || userInfo.getName() == null
                || userInfo.getPassword() == null
                || userInfo.getName().equals("")
                || userInfo.getPassword().equals("")
        ) {// 非法参数
            return 0;
        }
        return userService.add(userInfo);
    }

    @RequestMapping("/add2")
    public int add2(UserInfo userInfo) {
        // 参数校验 -> 调用Service层
        if(userInfo == null || userInfo.getName() == null
                || userInfo.getPassword() == null
                || userInfo.getName().equals("")
                || userInfo.getPassword().equals("")
        ) {// 非法参数
            return 0;
        }
        // 调用数据库执行添加操作，执行完添加之后，会将自增id设置到userInfo的id属性中
        userService.add2(userInfo);
        // 因此我们返回值应该是userInfo中的id属性值
        return userInfo.getId();
    }

    @RequestMapping("/update")
    // 这次直接使用参数接收
    public int update(int id, String password) {
        // 参数校验
        if(id <= 0 || password == null || "".equals(password)) {// 非法参数
            return 0;
        }
        return userService.update(id, password);
    }

    @RequestMapping("/delete")
    public int delete(Integer id) {
        if(id == null || id <= 0) {
            return 0;
        }
        return userService.delete(id);
    }

    @RequestMapping("/findbyname")
    public List<UserInfo> findByName(String name) {
        // 参数校验
        return userService.findByName(name);
    }

    @RequestMapping("/login")
    public Object login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("succ", 200);// 后端响应状态码
        String msg = "";
        int state = -1;// 登录状态码
        if(username != null && password != null &&
                !"".equals(username) && !"".equals(password)) {
            UserInfo userInfo = userService.login(username, password);
            if(userInfo != null && userInfo.getId() > 0) {
                // 登录成功
                state = 1;
                System.out.println("登陆成功: " + userInfo);
            }else {
                // 登录失败
                msg = "用户名或密码输入有误!请检查!";
            }
        }else {
            // 登录失败
            msg = "用户名或密码输入有误!请检查!";
        }
        map.put("state", state);
        map.put("msg", msg);
        return map;
    }

    @RequestMapping("/register")
    public Map<String, Object> register(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        String msg = "注册失败";
        int succ = 200;
        int state = -1;
        // 1.非空校验
        if(username != null && password != null
                && !"".equals(username) && !"".equals(password)) {
            // 调用service层，实现添加业务
            state = userService.register(username, password);
        }else {
            // 参数传递不全
            msg = "参数不全";
        }
        // 2.调用service实现添加业务

        // 3.将执行结果返回给前端
        map.put("succ", succ);
        map.put("state", state);
        map.put("msg", msg);
        return map;
    }
}
