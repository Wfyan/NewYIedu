package com.yi.mapper;

import com.yi.entity.StuIntegralInfo;

public interface StuIntegralInfoMapper {
    int deleteByPrimaryKey(Integer inteId);

    int insert(StuIntegralInfo record);

    int insertSelective(StuIntegralInfo record);

    StuIntegralInfo selectByPrimaryKey(Integer inteId);

    int updateByPrimaryKeySelective(StuIntegralInfo record);

    int updateByPrimaryKey(StuIntegralInfo record);
}