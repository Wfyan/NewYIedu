package com.yi.service.impl;

import com.yi.dto.KindInfoQueryCriteria;
import com.yi.entity.KindInfo;
import com.yi.mapper.KindInfoMapper;
import com.yi.service.KindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindInfoServiceImpl implements KindInfoService {
    @Autowired
    private KindInfoMapper kindInfoMapper;

    @Override
    public  int deleteByPrimaryKey(Integer kid){return kindInfoMapper.deleteByPrimaryKey(kid);}

    @Override
    public int insert(KindInfo record) {return kindInfoMapper.insert(record);}

/*    @Override
    public int insert(String kindName, Integer higherId, Integer level){
        KindInfo kindInfo = new KindInfo();
        kindInfo.setKindName(kindName);
        kindInfo.setLevel(level);
        if(level == 1){
            kindInfo.setHigherId(null);
        }else{
            kindInfo.setHigherId(higherId);
        }
        return kindInfoMapper.insert(kindInfo);
    }*/

    @Override
    public int insertSelective(KindInfo record){return kindInfoMapper.insertSelective(record);}

    @Override
    public KindInfo selectByPrimaryKey(Integer kid){return kindInfoMapper.selectByPrimaryKey(kid);}

    @Override
    public int updateByPrimaryKeySelective(KindInfo record){return kindInfoMapper.updateByPrimaryKeySelective(record);}

    @Override
    public int updateByPrimaryKey(KindInfoQueryCriteria record){return kindInfoMapper.updateByPrimaryKey(record);}

    @Override
    public List<KindInfo> selectByLevel(Integer level){return kindInfoMapper.selectByLevel(level);}

    @Override
    public KindInfo selectByName(String kindName){return kindInfoMapper.selectByName(kindName);}

    @Override
    public List<KindInfo> selectAll(){return kindInfoMapper.selectAll();}

    @Override
    public List<KindInfo> selectByAttribute(String onchoose) {
        return kindInfoMapper.selectByAttribute(onchoose);
    }

}
