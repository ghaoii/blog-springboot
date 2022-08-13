package com.ghaoi.blogspringboot.mapper;

import com.ghaoi.blogspringboot.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserInfo> getAll();

    int add(UserInfo userInfo);

    int add2(UserInfo userInfo);

    void add3(String name, String password, String p, int state);

    void add4(String name, String password, String p, Integer state);

    int update(int id, String password);

    void update2(int id, String name, String password);

    int delete(Integer id);

    int delete2(List<Integer> list);

    List<UserInfo> findByName(String name);

    List<UserInfo> getAll2(String order);

    List<UserInfo> getAll3();

    UserInfo login(String username, String password);

    List<UserInfo> login2(String username, String password);

    List<UserInfo> findListByName(String name);

    int register(String username, String password);
}
