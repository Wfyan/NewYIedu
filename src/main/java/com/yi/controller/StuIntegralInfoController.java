package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.OrderInfo;
import com.yi.service.OrderInfoService;
import com.yi.service.StuIntegralInfoService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stuinte")
@Api(value = "积分业务接口")
public class StuIntegralInfoController {

    @Autowired
    private StuIntegralInfoService service;


}
