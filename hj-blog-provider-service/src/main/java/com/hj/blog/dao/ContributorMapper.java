package com.hj.blog.dao;


import com.hj.blog.model.persistent.Contributor;

public interface ContributorMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Contributor record);

    Contributor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contributor record);

}