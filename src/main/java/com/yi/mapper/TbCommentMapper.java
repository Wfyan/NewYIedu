package com.yi.mapper;

import com.yi.dto.CommentReplyDto;
import com.yi.entity.TbComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCommentMapper {
    int deleteByPrimaryKey(Integer comId);

    int insert(TbComment record);

    int insertSelective(TbComment record);

    CommentReplyDto selectByPrimaryKey(Integer comId);

    int updateByPrimaryKeySelective(TbComment record);

    int updateByPrimaryKey(TbComment record);

    /**
     * 查询所有数据
     * @return
     */
    List<CommentReplyDto> selectAll(@Param("state") Integer state);

    int count(@Param("state") Integer state);

    /**
     * 根据课程ID，学生ID，时间多条件组合查询
     * @param cid
     * @param stuid
     * @param beforeDate
     * @param afterDate
     * @return
     */
    List<CommentReplyDto> selectByMultiple(@Param("cid") Integer cid, @Param("stuid") String stuid, @Param("state") Integer state,
                                     @Param("beforeDate") String beforeDate, @Param("afterDate") String afterDate);
    /**
     * 统计总数，用于分页
     * @param state
     * @return
     */
    int counts(@Param("cid") Integer cid, @Param("stuid") String stuid, @Param("state") Integer state,
               @Param("beforeDate") String beforeDate, @Param("afterDate") String afterDate);
}