package com.yi.mapper;

import com.yi.entity.Grade;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer scid);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer scid);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}