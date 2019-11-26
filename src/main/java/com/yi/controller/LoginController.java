package com.yi.controller;

import com.yi.service.ManagerLoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ManagerLoginService managerLoginService;

    @RequestMapping("/manager/goLogin")
    public Result authLogin(String name, String password) {
       return managerLoginService.goLogin(name,password);
    }



}
