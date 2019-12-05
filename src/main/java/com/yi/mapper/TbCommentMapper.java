package com.yi.mapper;

import com.yi.entity.TbComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbCommentMapper {
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
    List<TbComment> selectAll();

    /**
     * 根据课程ID，学生ID，时间多条件组合查询
     * @param cid
     * @param stuid
     * @param beforeDate
     * @param afterDate
     * @return
     */
    List<TbComment> selectByMultiple(@Param("cid") Integer cid,@Param("stuid") String stuid,
                                     @Param("beforeDate") String beforeDate,@Param("afterDate") String afterDate);
}