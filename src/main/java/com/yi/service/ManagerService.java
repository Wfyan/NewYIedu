package com.yi.service;

import com.yi.entity.TbManager;

import java.util.List;

public interface ManagerService {
    int deleteByPrimaryKey(Integer id);

    int insert(TbManager record);

    int insertSelective(TbManager record);

    TbManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbManager record);

    int updateByPrimaryKey(TbManager record);
    /**
     * 查询所有数据
     * @return
     */
    List<TbManager> selectAll();
    /**
     * 根据用户名获取信息
     * @param userName
     * @return
     */
    TbManager getByName(String userName);

    /**
     * 根据账号密码获取信息（用于登录）
     * @param name
     * @param password
     * @return
     */
    TbManager goLogin(String name, String password);

    /**
     * 根据手机号获取信息
     * @param phone
     * @return
     */
    TbManager selectByPhone(String phone);
    /**
     * 根据邮箱获取信息
     * @param email
     * @return
     */
    TbManager selectByEmail(String email);
    /**
     * 统计总数，用于分页
     * @return
     */
    int counts();
}
