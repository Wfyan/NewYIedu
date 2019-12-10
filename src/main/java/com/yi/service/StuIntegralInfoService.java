package com.yi.service;

import com.yi.entity.StuIntegralInfo;

import java.util.List;

public interface StuIntegralInfoService {
    int deleteByPrimaryKey(Integer inteId);

    int insert(StuIntegralInfo record);

    int insertSelective(StuIntegralInfo record);

    StuIntegralInfo selectByPrimaryKey(Integer inteId);

    int updateByPrimaryKeySelective(StuIntegralInfo record);

    int updateByPrimaryKey(StuIntegralInfo record);
}
