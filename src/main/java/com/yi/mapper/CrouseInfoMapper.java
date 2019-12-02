package com.yi.mapper;

import com.yi.entity.CrouseInfo;

import java.util.List;

public interface CrouseInfoMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(CrouseInfo record);

    int insertSelective(CrouseInfo record);

    CrouseInfo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(CrouseInfo record);

    int updateByPrimaryKey(CrouseInfo record);

    List<CrouseInfo> selectByKid(Integer kid);

    CrouseInfo selectByName(String cname);

    List<CrouseInfo> fuzzyQueryByName(String cname);    //模糊查询

    List<CrouseInfo> selectAll();

}