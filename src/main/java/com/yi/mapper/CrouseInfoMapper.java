package com.yi.mapper;

import com.yi.entity.CrouseInfo;
import com.yi.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

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

    int count();

    List<CrouseInfo> multiCriteriaQuery(@Param("kindName")String kindName, @Param("cname")String cname,
                                        @Param("beforeDate") String beforeDate, @Param("afterDate") String afterDate,
                                        @Param("price")Double price, @Param("tecname")String tecname, @Param("phone")String phone);

    int counts(@Param("kindName")String kindName, @Param("cname")String cname,
               @Param("beforeDate") String beforeDate, @Param("afterDate") String afterDate,
               @Param("price")Double price, @Param("tecname")String tecname, @Param("phone")String phone);

    List<CrouseInfo> selectByTecname(String tecname);

    List<CrouseInfo> selectByAttribute(String onchoose);
}