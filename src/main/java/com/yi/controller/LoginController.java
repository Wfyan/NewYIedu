package com.yi.controller;

import com.yi.service.LoginService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping("/goLogin")
    public Result authLogin(String name, String password) {
       return service.goLogin(name,password);
    }

}
