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
     * 根据用户名获取信息
     * @param stuname
     * @return
     */
    List<TbStudent> getByName(String stuname);
    /**
     * 根据手机号密码获取信息（用于登录）
     * @param phone
     * @param stupassword
     * @return
     */
    TbStudent goLoginByPhone(String phone, String stupassword);
    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    TbStudent selectByPhone(String phone);
    /**
     * 根据手机号/状态/时间组合查询 也用于查询所有
     * @param state
     * @param phone
     * @param beforeDate
     * @param afterDate
     * @return
     */
    List<TbStudent> selects(Integer state,String phone, String beforeDate, String afterDate);

    /**
     * 统计总数，用于分页
     * @param state
     * @return
     */
    int counts(Integer state,String beforeDate,String afterDate);
}
