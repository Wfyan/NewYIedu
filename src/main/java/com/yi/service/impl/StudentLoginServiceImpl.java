package com.yi.service.impl;

import com.yi.dto.LoginOk;
<<<<<<< HEAD
import com.yi.entity.TbManager;
import com.yi.mapper.TbManagerMapper;
import com.yi.service.ManagerLoginService;
=======
import com.yi.entity.Permission;
import com.yi.entity.TbStudent;
import com.yi.mapper.PermissionMapper;
import com.yi.mapper.TbStudentMapper;
>>>>>>> 49f47aeeb41f5292483bd371ccca8aa008c67c08
import com.yi.service.StudentLoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {
<<<<<<< HEAD
=======
    @Autowired
    private TbStudentMapper studentMapper;
>>>>>>> 49f47aeeb41f5292483bd371ccca8aa008c67c08
    @Autowired
    private PermissionMapper mapper;

    @Override
<<<<<<< HEAD
    public Result goLoginByName(String name, String password) {
        return null;
    }

    @Override
    public Result goLoginByPhone(String phone, String password) {
        return null;
=======
    public Result goLoginByPhone(String phone, String password) {
        TbStudent student = studentMapper.selectByPhone(phone);
        if(student == null){
            return new Result().error("该手机号未注册");
        }
        if(student.getStupassword().equals(password)){
            return new Result().successMessage("登录成功！",loginOk(student,mapper.selectByLevel(3)));
        }
        return new Result().error("账号密码错误！");
>>>>>>> 49f47aeeb41f5292483bd371ccca8aa008c67c08
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
    public Result logout() {
        return null;
    }
}
