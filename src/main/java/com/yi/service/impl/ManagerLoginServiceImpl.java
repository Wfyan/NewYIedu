package com.yi.service.impl;

import com.yi.dto.LoginOk;
import com.yi.entity.TbManager;
import com.yi.mapper.TbManagerMapper;
import com.yi.mapper.TbStudentMapper;
import com.yi.service.ManagerLoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {
    @Autowired
    private TbManagerMapper managerMapper;

    /**
     * 管理员使用账号密码登录
     * @param name
     * @param password
     * @return
     */
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
        TbManager manager = managerMapper.selectByPhone(phone);
        if(manager==null){
            return new Result().error("该手机号码未注册！");
        }
        return new Result().success(manager);
    }

    @Override
    public Result logout() {
        return null;
    }

}
