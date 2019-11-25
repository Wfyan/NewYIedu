package com.yi.mapper;

import com.yi.entity.CrouseInfo;

public interface CrouseInfoMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(CrouseInfo record);

    int insertSelective(CrouseInfo record);

    CrouseInfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(CrouseInfo record);

    int updateByPrimaryKey(CrouseInfo record);
}