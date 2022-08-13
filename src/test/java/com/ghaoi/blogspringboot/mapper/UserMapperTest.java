package com.ghaoi.blogspringboot.mapper;

import com.ghaoi.blogspringboot.model.ArticleInfo;
import com.ghaoi.blogspringboot.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void login() {
        UserInfo userInfo = userMapper.login("admin", " 'or 1='1");
        System.out.println(userInfo);
    }

    @Test
    void findListByName() {
        userMapper.findListByName("admin");
    }

    @Test
    void getAll3() {
        List<UserInfo> list = userMapper.getAll3();
        System.out.println(list);
    }

    @Test
    void add3() {
        userMapper.add3("Dua", "Dua", "NewRules.png", 1);
    }

    @Test
    void add4() {
        userMapper.add4("Sam", "Sam", null, null);
    }

    @Test
    void login2() {
        List<UserInfo> ret = userMapper.login2(null, null);
        for(UserInfo user : ret) {
            System.out.println(user);
        }
    }

    @Test
    void update2() {
        userMapper.update2(1, null, "2333");
    }

    @Test
    void delete2() {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        userMapper.delete2(list);
    }
}