package com.yi.service;

import com.yi.entity.TbComment;
import io.swagger.models.auth.In;

import java.util.List;

public interface CommentService {
    int deleteByPrimaryKey(Integer comId);

    int insert(TbComment record);

    int insertSelective(TbComment record);

    TbComment selectByPrimaryKey(Integer comId);

    int updateByPrimaryKeySelective(TbComment record);

    int updateByPrimaryKey(TbComment record);

    /**
     * 查询所有数据
     * @return
     */
    List<TbComment> selectAll(Integer state);

    int count(Integer state);

    /**
     * 根据课程ID，学生ID，时间多条件组合查询
     * @param cid
     * @param stuid
     * @param beforeDate
     * @param afterDate
     * @return
     */
    List<TbComment> selectByMultiple(Integer cid, String stuid,Integer state, String beforeDate, String afterDate);

    /**
     * 统计总数，用于分页
     * @param state
     * @return
     */
    int counts(Integer cid, String stuid, Integer state, String beforeDate, String afterDate);
}
