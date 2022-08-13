package com.ghaoi.blogspringboot.controller;

import com.ghaoi.blogspringboot.model.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional// 添加该注解后，测试完成后进行回滚操作,因此不会污染数据库
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    void add() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Dua");
        userInfo.setPassword("888");
        // 调用需要进行单元测试的方法
        int ret = userController.add(userInfo);
        // 判断ret返回的结果是否为1，为1则说明添加成功，否则这里就会报错
        Assertions.assertEquals(ret, 1);
    }

    @Test
    void getAll() {
    }

    @Test
    void add2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Lana");
        userInfo.setPassword("2233");
        // 调用需要进行单元测试的方法
        int id = userController.add2(userInfo);
        System.out.println("自增id: " + id);
    }

    @Test
    void update() {
        int ret = userController.update(1, "3344");
        Assertions.assertEquals(ret, 1);
    }

    @Test
    void delete() {
        int ret = userController.delete(3);
        Assertions.assertEquals(ret, 1);
    }
}