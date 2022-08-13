package com.ghaoi.blogspringboot.service;

import com.ghaoi.blogspringboot.mapper.UserMapper;
import com.ghaoi.blogspringboot.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int add(UserInfo userInfo) {
        // 服务(方法编排/数据组装)
        return userMapper.add(userInfo);
    }

    public List<UserInfo> getAll() {
        return userMapper.getAll();
    }

    public int add2(UserInfo userInfo) {
        userMapper.add2(userInfo);
        return userInfo.getId();
    }

    public int update(int id, String password) {
        return userMapper.update(id, password);
    }

    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    public List<UserInfo> findByName(String name) {
        return userMapper.findByName(name);
    }

    public List<UserInfo> getAll2(String order) {
        return userMapper.getAll2(order);
    }

    public UserInfo login(String username, String password) {
        return userMapper.login(username, password);
    }

    public int register(String username, String password) {
        return userMapper.register(username, password);
    }
}
