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
     * 根据评论ID，学生ID 条件查询
     * @param comId
     * @param stuid
     * @return
     */
    List<TbReply> selects(Integer comId, String stuid,Integer state);

    /**
     * 统计总数，用于分页
     * @param comId
     * @param stuid
     * @return
     */
    int counts(Integer comId, String stuid,Integer state);
}
