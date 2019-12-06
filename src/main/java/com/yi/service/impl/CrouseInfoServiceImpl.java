package com.yi.service.impl;

import com.yi.entity.CrouseInfo;
import com.yi.mapper.CrouseInfoMapper;
import com.yi.service.CrouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return crouseInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CrouseInfo> selectByKid(Integer kid) {
        return crouseInfoMapper.selectByKid(kid);
    }

    @Override
    public CrouseInfo selectByName(String cname) {
        return crouseInfoMapper.selectByName(cname);
    }

    @Override
    public List<CrouseInfo> fuzzyQueryByName(String cname) {
        return crouseInfoMapper.fuzzyQueryByName(cname);
    }

    @Override
    public List<CrouseInfo> selectAll(){return crouseInfoMapper.selectAll();}

    @Override
    public int count() {
        return crouseInfoMapper.count();
    }

    @Override
    public List<CrouseInfo> multiCriteriaQuery(String kindName, String cname, String beforeDate,
                                               String afterDate, Double price, String tecname, String phone) {
        return crouseInfoMapper.multiCriteriaQuery(kindName, cname, beforeDate, afterDate, price, tecname, phone);
    }

    @Override
    public int counts(String kindName, String cname, String beforeDate,
                      String afterDate, Double price, String tecname, String phone) {
        return crouseInfoMapper.counts(kindName, cname, beforeDate, afterDate, price, tecname, phone);
    }

    @Override
    public List<CrouseInfo> selectByTecname(String tecname) {
        return crouseInfoMapper.selectByTecname(tecname);
    }

}
