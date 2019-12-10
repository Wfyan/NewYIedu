package com.yi.service.impl;

import com.yi.entity.StuIntegralInfo;
import com.yi.mapper.StuIntegralInfoMapper;
import com.yi.service.StuIntegralInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuIntegralInfoServiceImpl implements StuIntegralInfoService {
    @Autowired
    private StuIntegralInfoMapper stuIntegralInfoMapper;


    @Override
    public int deleteByPrimaryKey(Integer inteId) {
        return stuIntegralInfoMapper.deleteByPrimaryKey(inteId);
    }

    @Override
    public int insert(StuIntegralInfo record) {
        return stuIntegralInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(StuIntegralInfo record) {
        return stuIntegralInfoMapper.insertSelective(record);
    }

    @Override
    public StuIntegralInfo selectByPrimaryKey(Integer inteId) {
        return stuIntegralInfoMapper.selectByPrimaryKey(inteId);
    }

    @Override
    public int updateByPrimaryKeySelective(StuIntegralInfo record) {
        return stuIntegralInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StuIntegralInfo record) {
        return stuIntegralInfoMapper.updateByPrimaryKey(record);
    }
}
