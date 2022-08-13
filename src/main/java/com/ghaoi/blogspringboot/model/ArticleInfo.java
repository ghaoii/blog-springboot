package com.ghaoi.blogspringboot.model;

import com.ghaoi.blogspringboot.model.UserInfo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private Integer rcount;
    // 包含了UserInfo对象
    private UserInfo user;
}
