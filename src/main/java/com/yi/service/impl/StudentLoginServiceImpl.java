package com.yi.service.impl;

import com.yi.dto.LoginOk;
<<<<<<< HEAD
<<<<<<< HEAD
import com.yi.entity.TbManager;
import com.yi.mapper.TbManagerMapper;
import com.yi.mapper.TbStudentMapper;
import com.yi.service.ManagerLoginService;
=======
=======
import com.yi.entity.Permission;
>>>>>>> master
import com.yi.entity.TbStudent;
import com.yi.mapper.PermissionMapper;
import com.yi.mapper.TbStudentMapper;
>>>>>>> master
import com.yi.service.StudentLoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {
    @Autowired
<<<<<<< HEAD
    private TbStudentMapper tbStudentMapper;


    @Override
    public Result goLoginByName(String name, String password) {
        return null;
    }

    @Override
    public Result goLoginByPhone(String phone, String password) {
        return null;
    }

    @Override
=======
    private TbStudentMapper studentMapper;
    @Autowired
    private PermissionMapper mapper;

    @Override
    public Result goLoginByPhone(String phone, String password) {
        TbStudent student = studentMapper.selectByPhone(phone);
        if(student == null){
            return new Result().error("该手机号未注册");
        }
        if(student.getStupassword().equals(password)){
            return new Result().successMessage("登录成功！",loginOk(student,mapper.selectByLevel(3)));
        }
        return new Result().error("账号密码错误！");
    }
    private static LoginOk loginOk(TbStudent student, List<Permission> permissions){
        LoginOk loginOk =  new LoginOk();
        loginOk.setName(student.getStuname());
        loginOk.setId(student.getPhone());
        loginOk.setRoleId(student.getRoleId());
        loginOk.setList(permissions);
        return loginOk;
    }

    @Override
>>>>>>> master
    public Result logout() {
        return null;
    }
}
