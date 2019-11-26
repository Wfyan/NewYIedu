package com.yi.service;

import com.yi.util.Result;

public interface ManagerLoginService {

    /**
     * 根据账号密码获取信息（用于管理员登录）
     * @param name
     * @param password
     * @return
     */
    Result goLogin(String name, String password);

    /**
     * 根据手机号获取信息
     * @param phone
     * @return
     */
    Result selectByPhone(String phone);

    /**
     * 退出登录
     */
    Result logout();

}
