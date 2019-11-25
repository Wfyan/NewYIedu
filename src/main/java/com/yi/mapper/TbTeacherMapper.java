package com.yi.mapper;

import com.yi.entity.TbTeacher;

public interface TbTeacherMapper {
    int deleteByPrimaryKey(String tecid);

    int insert(TbTeacher record);

    int insertSelective(TbTeacher record);

    TbTeacher selectByPrimaryKey(String tecid);

    int updateByPrimaryKeySelective(TbTeacher record);

    int updateByPrimaryKey(TbTeacher record);
}