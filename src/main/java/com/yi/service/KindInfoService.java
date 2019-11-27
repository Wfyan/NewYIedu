package com.yi.service;

import com.yi.entity.KindInfo;

import java.util.List;
import java.util.Map;

public interface KindInfoService {
    int deleteByPrimaryKey(Integer kid);

    int insert(String kindName, Integer higherId, Integer level);

    int insertSelective(KindInfo record);

    KindInfo selectByPrimaryKey(Integer kid);

    int updateByPrimaryKeySelective(KindInfo record);

    int updateByPrimaryKey(KindInfo record);

    List<Integer> selectHigher(Integer level);

    List<Map<String, Object>> selectAll(int higherId);

}
