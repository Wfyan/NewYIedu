package com.yi.controller;

import com.yi.service.ManagerLoginService;
import com.yi.service.StudentLoginService;
import com.yi.service.TeacherLoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ManagerLoginService managerLoginService;
    @Autowired
    private StudentLoginService studentLoginService;
    @Autowired
    private TeacherLoginService teacherLoginService;

    /**
     * 管理员通过账号密码登录
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/manager/goLogin")
    public Result authLogin(String name, String password) {
       return managerLoginService.goLogin(name,password);
    }

    /**
     * 学生通过手机号密码登录
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping("/stu/goLogin")
    public Result stuLogin(String phone, String password) {
        return studentLoginService.goLoginByPhone(phone,password);
    }

    /**
     * 教师通过手机号密码的登录
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping("/tec/goLogin")
    public Result tecLogin(String phone, String password) {
        return teacherLoginService.goLoginByPhone(phone,password);
    }


}
