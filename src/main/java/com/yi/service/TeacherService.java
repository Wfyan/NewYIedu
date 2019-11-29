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
     * 查询所有数据
     * @return
     */
    List<TbTeacher> selectAll();
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
}
