package com.ghaoi.blogspringboot.mapper;

import com.ghaoi.blogspringboot.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleInfoMapper {
    List<ArticleInfo> getAll();

    List<ArticleInfo> getAll2();


}
