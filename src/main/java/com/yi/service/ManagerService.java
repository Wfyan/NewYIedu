package com.yi.service;

import com.yi.entity.TbManager;
import com.yi.util.Result;

public interface ManagerService {
    int deleteByPrimaryKey(Integer id);

    int insert(TbManager record);

    int insertSelective(TbManager record);

    TbManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbManager record);

    int updateByPrimaryKey(TbManager record);
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
}
