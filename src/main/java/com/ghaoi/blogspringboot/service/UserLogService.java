package com.ghaoi.blogspringboot.service;

import com.ghaoi.blogspringboot.mapper.UserLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserLogService {
    @Resource
    private UserLogMapper userLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int add(String desc) {
        int a = 10 / 0;
        return userLogMapper.add(desc);
    }
}
