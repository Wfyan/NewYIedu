package com.yi.service;

import com.yi.entity.TbStudent;

public interface StudentService {
    int deleteByPrimaryKey(String stuid);

    int insert(TbStudent record);

    int insertSelective(TbStudent record);

    TbStudent selectByPrimaryKey(String stuid);

    int updateByPrimaryKeySelective(TbStudent record);

    int updateByPrimaryKey(TbStudent record);

}
