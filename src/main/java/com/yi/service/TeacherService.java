package com.yi.service;

import com.yi.entity.TbTeacher;

import java.util.List;

public interface TeacherService {
    int deleteByPrimaryKey(String tecid);

    int insert(TbTeacher record);

    int insertSelective(TbTeacher record);

    TbTeacher selectByPrimaryKey(String tecid);

    int updateByPrimaryKeySelective(TbTeacher record);

    int updateByPrimaryKey(TbTeacher record);

    /**
     * 根据用户名获取信息
     * @param tecname
     * @return
     */
    List<TbTeacher> getByName(String tecname);
    /**
     * 根据手机号密码获取信息（用于登录）
     * @param phone
     * @param tecpassword
     * @return
     */
    TbTeacher goLoginByPhone(String phone, String tecpassword);
    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    TbTeacher selectByPhone(String phone);
    /**
     * 根据手机号/状态/时间组合查询 也用于查询所有
     * @param state
     * @param phone
     * @param beforeDate
     * @param afterDate
     * @return
     */
    List<TbTeacher> selects(Integer state,String phone, String beforeDate, String afterDate);

    /**
     * 统计总数，用于分页
     * @param state
     * @return
     */
    int counts(Integer state,String beforeDate,String afterDate);
}
