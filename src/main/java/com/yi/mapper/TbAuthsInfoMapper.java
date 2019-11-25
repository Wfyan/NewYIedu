package com.yi.mapper;

import com.yi.entity.TbAuthsInfo;

public interface TbAuthsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbAuthsInfo record);

    int insertSelective(TbAuthsInfo record);

    TbAuthsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbAuthsInfo record);

    int updateByPrimaryKey(TbAuthsInfo record);
}