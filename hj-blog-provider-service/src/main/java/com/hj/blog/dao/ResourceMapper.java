package com.hj.blog.dao;


import com.hj.blog.model.persistent.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resource record);

}