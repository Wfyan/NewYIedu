package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.dto.KindInfoQueryCriteria;
import com.yi.entity.KindInfo;
import com.yi.service.KindInfoService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("kindInfo")
@Api(value = "课程类别业务接口")
public class KindInfoController {
    @Autowired
    private KindInfoService kindInfoService;

    @ApiOperation(value = "删除课程类别",httpMethod = "GET",response = Result.class,notes = "根据Id删除课程类别")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(Integer id){
        return kindInfoService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功"):new Result().error("删除失败");
    }

    /**
     * 添加课程类别
     * @param record
     * @return
     */
    @ApiOperation(value = "添加课程类别",httpMethod = "POST",response = Result.class,notes = "添加课程类别")
    @PostMapping("/insertSelective")
    public Result insertKindInfo(@RequestBody KindInfo record ){
        try{
            String kindName = record.getKindName();
            KindInfo name = kindInfoService.selectByName(kindName);
            if(name == null){
                return kindInfoService.insertSelective(record) > 0 ? new Result().successMessage("添加成功"): new Result().error("添加失败");
            }else {
                return new Result().error("课程类别已存在");
            }
        }catch (Exception e ){
            e.printStackTrace();
            return new Result().error(-1,"添加类别出现异常，请调整参数后重试");
        }
    }

    @ApiOperation(value = "查询特定课程类别",httpMethod = "GET",response = Result.class,notes = "根据Id查询课程类别")
    @GetMapping("selectByPrimaryKey")
    public Result selectByPrimaryKey(Integer kid){
        KindInfo kindInfo = kindInfoService.selectByPrimaryKey(kid);
        return kindInfo == null ? new Result().error("无数据"):new Result().success(kindInfo);
    }

    @ApiOperation(value = "更新课程类别",httpMethod = "POST",response = Result.class,notes = "根据Id更新课程类别")
    @PostMapping("updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody KindInfoQueryCriteria record){
        try {
            return  kindInfoService.updateByPrimaryKey(record) > 0 ?  new Result().successMessage("修改成功"):new Result("修改失败");
        }catch (Exception e){
            return new Result().error("修改异常");
        }
    }

    /**
     * 获取上一级level
     * @param level
     * @return
     */
    @ApiOperation(value = "查询特定课程类别",httpMethod = "GET",response = Result.class,notes = "根据课程类别查询上一级课程类别")
    @GetMapping("/getHigherLevel")
    public Result getHigherLevel(Integer level, @RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<KindInfo> list = kindInfoService.selectByLevel(level-1);
        if (list.size() == 0){
            return new Result().successMessage("无数据");
        }else {
            return new Result().success(list, list.size());
        }
    }

    /**
     * 根据课程类别查询下一级课程类别
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询特定课程类别",httpMethod = "GET",response = Result.class,notes = "根据课程类别查询下一级课程类别")
    @GetMapping("/selectNextLevel")
    public Result selectNextLevel(Integer level, @RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<KindInfo> list = kindInfoService.selectByLevel(level+1);
        if (list.size() == 0){
            return new Result().successMessage("无数据");
        }else {
            return new Result().success(list, list.size());
        }
    }

    /**
     * 根据课程类别名称查询课程类别
     * @param kindName
     * @return
     */
    @ApiOperation(value = "通过课程名称查询",httpMethod = "GET",response = Result.class,notes = "根据课程名称查询课程类别")
    @GetMapping("/selectByName")
    public Result selectByName(String kindName){
            KindInfo kindInfo = kindInfoService.selectByName(kindName);
            return kindInfo == null ? new Result().error("无数据"):new Result().success(kindInfo);
    }

    /**
     * 查询所有课程类别
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有",httpMethod = "GET",response = Result.class,notes = "查询所有课程类别（接受页码和页码大小两个参数）")
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<KindInfo> list =kindInfoService.selectAll();
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

//    public static void main(String[] args) {
//        JSONObject  json =new JSONObject();
//        json.put("a","1");
//        json.put("b",null);
//        Integer a =json.getInteger("a");
//        System.out.println(a);
//        Integer b =json.getInteger("b");
//        System.out.println(b);
//    }

}
