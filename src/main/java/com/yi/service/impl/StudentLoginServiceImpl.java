package com.yi.service.impl;

import com.yi.dto.LoginOk;
import com.yi.entity.TbManager;
import com.yi.mapper.TbManagerMapper;
import com.yi.service.ManagerLoginService;
import com.yi.service.StudentLoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {
    @Autowired
    private TbManagerMapper managerMapper;

    @Override
    public Result goLoginByName(String name, String password) {
        return null;
    }

    @Override
    public Result goLoginByPhone(String phone, String password) {
        return null;
    }
    private static LoginOk loginOk(TbManager manager){
        LoginOk loginOk = new LoginOk();
        loginOk.setName(manager.getName());
        loginOk.setId(manager.getId());
        return loginOk;
    }

    @Override
    public Result logout() {
        return null;
    }

}
