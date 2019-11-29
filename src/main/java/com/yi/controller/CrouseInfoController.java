package com.yi.controller;

import com.yi.dto.KindInfoQueryCriteria;
import com.yi.entity.CrouseInfo;
import com.yi.service.CrouseInfoService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CrouseInfo")
public class CrouseInfoController {

    @Autowired
    private CrouseInfoService crouseInfoService;

    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(Integer cid){
        return crouseInfoService.deleteByPrimaryKey(cid) > 0 ? new Result().successMessage("删除成功"):new Result("删除失败");
    }

    /**
     * 添加课程
     * @param record
     * @return
     */
    @PostMapping("/insert")
    public Result insertCrouseInfo(@RequestBody CrouseInfo record ){
        try{
            String cname = record.getCname();
            CrouseInfo name = crouseInfoService.selectByName(cname);
            if(name == null){
                return crouseInfoService.insert(record) > 0 ? new Result().successMessage("添加成功"): new Result().error("添加失败");
            }else {
                return new Result().error("课程已存在");
            }
        }catch (Exception e ){
            e.printStackTrace();
            return new Result().error(-1,"添加课程出现异常，请调整参数后重试");
        }
    }

    @GetMapping("selectByPrimaryKey")
    public Result selectByPrimaryKey(Integer cid){
        CrouseInfo record = crouseInfoService.selectByPrimaryKey(cid);
        return record == null ? new Result().error("无数据"):new Result().success(record);
    }

    @PostMapping("updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody KindInfoQueryCriteria record){
        try {
            return  crouseInfoService.updateByPrimaryKey(record) > 0 ?  new Result().successMessage("修改成功"):new Result("修改失败");
        }catch (Exception e){
            return new Result().error("修改异常");
        }
    }

    /**
     * 根据课程名称查询课程
     * @param cname
     * @return
     */
    @GetMapping("/selectByName")
    public Result selectByName(String cname){
        CrouseInfo record = crouseInfoService.selectByName(cname);
        return record == null ? new Result().error("无数据"):new Result().success(record);
    }
}
