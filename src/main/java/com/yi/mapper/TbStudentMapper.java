package com.yi.mapper;

import com.yi.entity.TbStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbStudentMapper {
    int deleteByPrimaryKey(String stuid);

    int insert(TbStudent record);

    int insertSelective(TbStudent record);

    TbStudent selectByPrimaryKey(String stuid);

    int updateByPrimaryKeySelective(TbStudent record);

    int updateByPrimaryKey(TbStudent record);

    /**
     * 根据用户名获取信息
     * @param stuname
     * @return
     */
    List<TbStudent> getByName(@Param("stuname") String stuname);
    /**
     * 根据手机号密码获取信息（用于登录）
     * @param phone
     * @param stupassword
     * @return
     */
    TbStudent goLoginByPhone(@Param("phone") String phone, @Param("stupassword") String stupassword);

    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    TbStudent selectByPhone(@Param("phone") String phone);

    /**
     * 根据手机号/状态/时间组合查询 也用于查询所有
     * @param state
     * @param phone
     * @param beforeDate
     * @param afterDate
     * @return
     */
    List<TbStudent> selects(@Param("state") Integer state,@Param("phone") String phone,
                                     @Param("beforeDate") String beforeDate,@Param("afterDate") String afterDate);

    /**
     * 统计总数，用于分页
     * @param state
     * @return
     */
    int counts(@Param("state") Integer state,@Param("beforeDate") String beforeDate,@Param("afterDate") String afterDate);
    /**
     * 根据邮箱获取信息
     * @param email
     * @return
     */
    TbStudent selectByEmail(@Param("email") String email);
}