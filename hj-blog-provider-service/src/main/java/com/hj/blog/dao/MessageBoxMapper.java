package com.hj.blog.dao;

import com.hj.blog.model.persistent.MessageBox;
import com.hj.blog.common.orm.DigitalPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageBoxMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(MessageBox record);

    MessageBox selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageBox record);

    List<MessageBox> getMessagesByPage(@Param("page") DigitalPage page,
                                       @Param("messageBox") MessageBox messageBox);
}