package com.yi.mapper;

import com.yi.entity.KindInfo;

public interface KindInfoMapper {
    int deleteByPrimaryKey(Integer kid);

    int insert(KindInfo record);

    int insertSelective(KindInfo record);

    KindInfo selectByPrimaryKey(Integer kid);

    int updateByPrimaryKeySelective(KindInfo record);

    int updateByPrimaryKey(KindInfo record);
}