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
     * 查询所有数据
     * @return
     */
    List<TbStudent> selectAll();
    /**
     * 根据用户名获取信息
     * @param stuname
     * @return
     */
    List<TbStudent> getByName(@Param("stuname") String stuname);
    /**
     * 根据账号密码获取信息（用于登录）
     * @param phone
     * @param stupassword
     * @return
     */
    TbStudent goLoginByPhone(@Param("phone") String phone, @Param("stupassword") String stupassword);
    /**
     * 根据账号密码获取信息（用于登录）
     * @param stuname
     * @param stupassword
     * @return
     */
    TbStudent goLoginByName(@Param("stuname") String stuname, @Param("stupassword") String stupassword);
    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    TbStudent selectByPhone(@Param("phone") String phone);
}