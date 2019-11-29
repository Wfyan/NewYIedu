package com.yi.service;

import com.yi.util.Result;

public interface TeacherLoginService {

    /**
     * 根据账号密码获取信息
     * @param phone
     * @param password
     * @return
     */
    Result goLoginByPhone(String phone, String password);

    /**
     * 退出登录
     */
    Result logout();

}
