package com.yi.mapper;

import com.yi.entity.TbReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbReplyMapper {
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
    List<TbReply> selects(@Param("comId") Integer comId,@Param("stuid") String stuid,@Param("state") Integer state);

    /**
     * 统计总数，用于分页
     * @param comId
     * @param stuid
     * @return
     */
    int counts(@Param("comId") Integer comId,@Param("stuid") String stuid,@Param("state") Integer state);
}