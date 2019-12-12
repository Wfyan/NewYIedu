package com.yi.mapper;

import com.yi.entity.StuIntegralInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuIntegralInfoMapper {
    int deleteByPrimaryKey(Integer inteId);

    int insert(StuIntegralInfo record);

    int insertSelective(StuIntegralInfo record);

    StuIntegralInfo selectByPrimaryKey(Integer inteId);

    int updateByPrimaryKeySelective(StuIntegralInfo record);

    int updateByPrimaryKey(StuIntegralInfo record);

    /**
     * 根据来源名称查询
     * @param name
     * @return
     */
    StuIntegralInfo selectByName(@Param("stuid") String stuid,@Param("othername") String name);

    /**
     * 根据课程ID，学生ID，时间多条件组合查询以及标题模糊查询
     * @param stuid
     * @param name
     * @param beforeDate
     * @param afterDate
     * @return
     */
    List<StuIntegralInfo> selects(@Param("stuid") String stuid,@Param("othername") String name,
                                           @Param("beforeDate") String beforeDate, @Param("afterDate") String afterDate);

    /**
     * 统计总数，用于分页
     * @param stuid
     * @param name
     * @param beforeDate
     * @param afterDate
     * @return
     */
    int counts(@Param("stuid") String stuid,@Param("othername") String name,
               @Param("beforeDate") String beforeDate, @Param("afterDate") String afterDate);
}