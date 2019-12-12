package com.yi.mapper;

import com.yi.dto.KindInfoQueryCriteria;
import com.yi.entity.KindInfo;

import java.util.List;
import java.util.Map;

public interface KindInfoMapper {
    int deleteByPrimaryKey(Integer kid);

    int insert(KindInfo record);

    int insertSelective(KindInfo record);

    KindInfo selectByPrimaryKey(Integer kid);

    int updateByPrimaryKeySelective(KindInfo record);

    int updateByPrimaryKey(KindInfoQueryCriteria record);

    List<KindInfo> selectByLevel(Integer level);

    KindInfo selectByName(String name);

    List<KindInfo> selectAll();

    List<KindInfo> selectByAttribute(String onchoose);
}