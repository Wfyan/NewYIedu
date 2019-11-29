package com.yi.service;

import com.yi.dto.KindInfoQueryCriteria;
import com.yi.entity.KindInfo;

import java.util.List;

public interface KindInfoService {
    int deleteByPrimaryKey(Integer kid);

    int insert(KindInfo record);

    int insertSelective(KindInfo record);

    KindInfo selectByPrimaryKey(Integer kid);

    int updateByPrimaryKeySelective(KindInfo record);

    int updateByPrimaryKey(KindInfoQueryCriteria record);

    List<KindInfo> selectByLevel(Integer level);

    KindInfo selectByName(String kindName);

}
