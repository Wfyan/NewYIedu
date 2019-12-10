package com.yi.mapper;

import com.yi.entity.TbTeacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTeacherMapper {
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
    List<TbTeacher> getByName(@Param("tecname") String tecname);
    /**
     * 根据手机号密码获取信息（用于登录）
     * @param phone
     * @param tecpassword
     * @return
     */
    TbTeacher goLoginByPhone(@Param("phone") String phone, @Param("tecpassword") String tecpassword);

    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    TbTeacher selectByPhone(@Param("phone") String phone);
    /**
     * 根据邮箱获取信息
     * @param email
     * @return
     */
    TbTeacher selectByEmail(@Param("email") String email);

    /**
     * 根据手机号/状态/时间组合查询 也用于查询所有
     * @param state
     * @param phone
     * @param beforeDate
     * @param afterDate
     * @return
     */
    List<TbTeacher> selects(@Param("state") Integer state,@Param("phone") String phone,
                            @Param("beforeDate") String beforeDate,@Param("afterDate") String afterDate);

    /**
     * 统计总数，用于分页
     * @param state
     * @return
     */
    int counts(@Param("state") Integer state,@Param("beforeDate") String beforeDate,@Param("afterDate") String afterDate);
}