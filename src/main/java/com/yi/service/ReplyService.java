package com.yi.service;

import com.yi.entity.TbReply;

import java.util.List;

public interface ReplyService {
    int deleteByPrimaryKey(Integer repId);

    int insert(TbReply record);

    int insertSelective(TbReply record);

    TbReply selectByPrimaryKey(Integer repId);

    int updateByPrimaryKeySelective(TbReply record);

    int updateByPrimaryKey(TbReply record);
    /**
     * 查询所有数据
     * @return
     */
    List<TbReply> selectAll();

    /**
     * 查询某个评论下的所有回复
     * @param comId
     * @return
     */
    List<TbReply> selectByComId(Integer comId);

    /**
     * 查询某个学生用户的所有回复
     * @param stuid
     * @return
     */
    List<TbReply> selectByStuid(String stuid);
}
