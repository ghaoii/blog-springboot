package com.ghaoi.blogspringboot.mapper;

import com.ghaoi.blogspringboot.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleInfoMapperTest {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Test
    void getAll() {
        List<ArticleInfo> list = articleInfoMapper.getAll();
        System.out.println(list);
    }

    @Test
    void getAll2() {
        List<ArticleInfo> list = articleInfoMapper.getAll2();
        System.out.println(list);
    }
}