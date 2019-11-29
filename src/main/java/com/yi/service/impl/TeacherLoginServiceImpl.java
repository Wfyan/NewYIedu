package com.yi.service.impl;

import com.yi.dto.LoginOk;
import com.yi.entity.TbTeacher;
import com.yi.mapper.TbTeacherMapper;
import com.yi.service.TeacherLoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherLoginServiceImpl implements TeacherLoginService {
    @Autowired
    private TbTeacherMapper studentMapper;

    @Override
    public Result goLoginByPhone(String phone, String password) {
        TbTeacher student = studentMapper.selectByPhone(phone);
        if(student == null){
            return new Result().error("该手机号未注册");
        }
        if(student.getTecpassword().equals(password)){
            return new Result().successMessage("登录成功！",loginOk(student));
        }
        return new Result().error("账号密码错误！");
    }
    private static LoginOk loginOk(TbTeacher teacher){
        LoginOk loginOk =  new LoginOk();
        loginOk.setName(teacher.getTecname());
        loginOk.setId(teacher.getPhone());
        loginOk.setRoleId(teacher.getRoleId());
        return loginOk;
    }

    @Override
    public Result logout() {
        return null;
    }
}
