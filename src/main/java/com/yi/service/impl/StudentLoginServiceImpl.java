package com.yi.service.impl;

import com.yi.dto.LoginOk;
import com.yi.entity.TbStudent;
import com.yi.mapper.TbStudentMapper;
import com.yi.service.StudentLoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {
    @Autowired
    private TbStudentMapper studentMapper;

    @Override
    public Result goLoginByPhone(String phone, String password) {
        TbStudent student = studentMapper.selectByPhone(phone);
        if(student == null){
            return new Result().error("该手机号未注册");
        }
        if(student.getStupassword().equals(password)){
            return new Result().successMessage("登录成功！",loginOk(student));
        }
        return new Result().error("账号密码错误！");
    }
    private static LoginOk loginOk(TbStudent student){
        LoginOk loginOk =  new LoginOk();
        loginOk.setName(student.getStuname());
        loginOk.setId(student.getPhone());
        loginOk.setRoleId(student.getRoleId());
        return loginOk;
    }

    @Override
    public Result logout() {
        return null;
    }
}
