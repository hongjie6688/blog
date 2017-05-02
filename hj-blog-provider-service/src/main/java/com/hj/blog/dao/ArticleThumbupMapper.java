package com.hj.blog.dao;

import com.hj.blog.model.persistent.ArticleThumbup;
import org.apache.ibatis.annotations.Param;

public interface ArticleThumbupMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(ArticleThumbup record);

    ArticleThumbup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleThumbup record);

    ArticleThumbup selectByArticleIdAndKey(@Param("articleId") Integer articleId, @Param("ipAddress") String ipAddress);
}