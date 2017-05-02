package com.hj.blog.dao;


import com.hj.blog.model.persistent.ArticleCategory;

import java.util.List;

public interface ArticleCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ArticleCategory record);

    ArticleCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleCategory record);

    List<ArticleCategory> getAllArticleCategory();
}