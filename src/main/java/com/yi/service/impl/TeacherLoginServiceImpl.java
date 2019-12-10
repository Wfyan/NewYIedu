package com.yi.service.impl;

import com.yi.dto.LoginOk;
import com.yi.entity.RolePermission;
import com.yi.entity.TbTeacher;
import com.yi.mapper.RolePermissionMapper;
import com.yi.mapper.TbTeacherMapper;
import com.yi.service.TeacherLoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherLoginServiceImpl implements TeacherLoginService {
    @Autowired
    private TbTeacherMapper studentMapper;
    @Autowired
    private RolePermissionMapper mapper;

    @Override
    public Result goLoginByPhone(String phone, String password) {
        TbTeacher teacher = studentMapper.selectByPhone(phone);
        if(teacher == null){
            return new Result().error("该手机号未注册");
        }
        if(teacher.getTecpassword().equals(password)){
            return new Result().successMessage("登录成功！",loginOk(teacher,mapper.selectByRoleId(2)));
        }
        return new Result().error("账号密码错误！");
    }
    private static LoginOk loginOk(TbTeacher teacher, List<RolePermission> permissions){
        LoginOk loginOk =  new LoginOk();
        loginOk.setName(teacher.getTecname());
        loginOk.setId(teacher.getPhone());
        loginOk.setRoleId(teacher.getRoleId());
        loginOk.setList(permissions);
        return loginOk;
    }

    @Override
    public Result logout() {
        return null;
    }
}
