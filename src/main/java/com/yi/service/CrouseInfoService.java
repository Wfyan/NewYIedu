package com.yi.service;

import com.yi.entity.CrouseInfo;
import com.yi.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrouseInfoService {
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

    int count();

    List<CrouseInfo> multiCriteriaQuery(String kindName, String cname, String beforeDate,
                                         String afterDate, Double price, String tecname, String phone);

    int counts(String kindName, String cname, String beforeDate, String afterDate, Double price,
               String tecname, String phone);

    List<CrouseInfo> selectByTecname(String tecname);

    List<CrouseInfo> selectByAttribute(String onchoose);
}
