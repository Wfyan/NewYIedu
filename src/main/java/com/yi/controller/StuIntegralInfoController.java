package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.StuIntegralInfo;
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

    /**
     * 添加积分
     * @param record
     * @return
     */
    @ApiOperation(value = "添加积分",httpMethod = "POST",response = Result.class,
            notes = "添加积分，视频播放完毕后，向服务器发送添加积分请求")
    @PostMapping("/insert")
    public Result insertOrderInfo(@RequestBody StuIntegralInfo record ){
        if(service.selectByName(record.getStuid(),record.getOtherName())!=null){
            return new Result("已添加，无需响应！");
        }else{
            return service.insertSelective(record) > 0 ? new Result().successMessage("添加成功"):new Result("添加失败");
        }
    }

    @ApiOperation(value = "组合查询",httpMethod = "GET",response = Result.class,
            notes = "根据学生ID/名称/时间组合查询")
    @GetMapping("/selects")
    public Result selects(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize,
                                   String stuid, String name,
                                   String beforeDate, String afterDate){
        PageHelper.startPage(pageNum,pageSize);
        List<StuIntegralInfo> list = service.selects(stuid,name,beforeDate,afterDate);
        if (list.size() == 0){
            return new Result().successMessage("无数据");
        } else {
            return new Result().success(list,service.counts(stuid,name,beforeDate,afterDate));
        }
    }

}
