package com.yi.service.impl;

import com.yi.dto.LoginOk;
import com.yi.entity.TbManager;
import com.yi.entity.TbStudent;
import com.yi.mapper.TbManagerMapper;
import com.yi.mapper.TbStudentMapper;
import com.yi.service.LoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TbManagerMapper managerMapper;
    @Autowired
    private TbStudentMapper studentMapper;

    @Override
    public Result goLogin(String name, String password) {
        TbManager manager =managerMapper.getByName(name);
        if(manager == null){
            return Result.error("账号无效");
        }
        if(manager.getPassword().equals(password)){
            return Result.successMessage("登录成功",loginOk(manager));
        }
        return Result.error("用户名或密码错误");
    }
    private static LoginOk loginOk(TbManager manager){
        LoginOk loginOk = new LoginOk();
        loginOk.setName(manager.getName());
        loginOk.setId(manager.getId());
        return loginOk;
    }

    @Override
    public Result selectByPhone(String phone) {
        return null;
    }
}
