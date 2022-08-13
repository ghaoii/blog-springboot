package com.ghaoi.blogspringboot.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserInfo {
    // 这里要定义用户的属性，字段名要与数据库中完全一致
    private int id;
    private String name; // todo: 和数据库的字段不一致,username
    private String password;
    private String photo;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;
    private List<ArticleInfo> artList;
}
