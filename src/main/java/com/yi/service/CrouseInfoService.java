package com.yi.service;

import com.yi.entity.CrouseInfo;

public interface CrouseInfoService {
    int deleteByPrimaryKey(Integer cid);

    int insert(CrouseInfo record);

    int insertSelective(CrouseInfo record);

    CrouseInfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(CrouseInfo record);

    int updateByPrimaryKey(CrouseInfo record);

    CrouseInfo selectByName(String cname);
}
