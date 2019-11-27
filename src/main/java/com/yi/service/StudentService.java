package com.yi.service;

import com.yi.entity.TbStudent;

import java.util.List;

public interface StudentService {
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
    List<TbStudent> getByName(String stuname);
    /**
     * 根据账号密码获取信息（用于登录）
     * @param phone
     * @param stupassword
     * @return
     */
    TbStudent goLoginByPhone(String phone, String stupassword);
    /**
     * 根据账号密码获取信息（用于登录）
     * @param stuname
     * @param stupassword
     * @return
     */
    TbStudent goLoginByName(String stuname, String stupassword);
    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    TbStudent selectByPhone(String phone);
}
