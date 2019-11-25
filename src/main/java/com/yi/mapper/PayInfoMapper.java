package com.yi.mapper;

import com.yi.entity.PayInfo;

public interface PayInfoMapper {
    int deleteByPrimaryKey(String payId);

    int insert(PayInfo record);

    int insertSelective(PayInfo record);

    PayInfo selectByPrimaryKey(String payId);

    int updateByPrimaryKeySelective(PayInfo record);

    int updateByPrimaryKey(PayInfo record);
}