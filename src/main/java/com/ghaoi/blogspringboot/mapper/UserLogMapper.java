package com.ghaoi.blogspringboot.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLogMapper {
    public int add(String desc);
}
