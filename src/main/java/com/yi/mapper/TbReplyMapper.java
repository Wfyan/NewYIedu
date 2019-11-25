package com.yi.mapper;

import com.yi.entity.TbReply;

public interface TbReplyMapper {
    int deleteByPrimaryKey(Integer repId);

    int insert(TbReply record);

    int insertSelective(TbReply record);

    TbReply selectByPrimaryKey(Integer repId);

    int updateByPrimaryKeySelective(TbReply record);

    int updateByPrimaryKey(TbReply record);
}