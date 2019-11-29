package com.yi.service.impl;

import com.yi.entity.CrouseInfo;
import com.yi.entity.KindInfo;
import com.yi.mapper.CrouseInfoMapper;
import com.yi.service.CrouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class CrouseInfoServiceImpl implements CrouseInfoService {

    @Autowired
    private CrouseInfoMapper crouseInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer cid) {
        return crouseInfoMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int insert(CrouseInfo record) {
        return crouseInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(CrouseInfo record) {
        return crouseInfoMapper.insertSelective(record);
    }

    @Override
    public CrouseInfo selectByPrimaryKey(Integer cid) {
        return crouseInfoMapper.selectByPrimaryKey(cid);
    }

    @Override
    public int updateByPrimaryKeySelective(CrouseInfo record) {
        return crouseInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CrouseInfo record) {
        return updateByPrimaryKey(record);
    }

    @Override
    public CrouseInfo selectByName(String cname){return crouseInfoMapper.selectByName(cname);}
}
