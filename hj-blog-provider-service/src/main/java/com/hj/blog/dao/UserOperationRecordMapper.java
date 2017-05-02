package com.hj.blog.dao;


import com.hj.blog.model.persistent.UserOperationRecord;

public interface UserOperationRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserOperationRecord record);

    UserOperationRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserOperationRecord record);

}