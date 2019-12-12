package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.CrouseInfo;
import com.yi.service.CrouseInfoService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crouseInfo")
@Api(value = "课程信息业务接口")
public class CrouseInfoController {

    @Autowired
    private CrouseInfoService crouseInfoService;

    @ApiOperation(value = "删除课程",httpMethod = "GET",response = Result.class,notes = "根据Id删除课程")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(Integer cid){
        return crouseInfoService.deleteByPrimaryKey(cid) > 0 ? new Result().successMessage("删除成功"):new Result("删除失败");
    }

    /**
     * 添加课程
     * @param record
     * @return
     */
    @ApiOperation(value = "添加课程",httpMethod = "POST",response = Result.class,notes = "添加课程")
    @PostMapping("/insertSelective")
    public Result insertCrouseInfo(@RequestBody CrouseInfo record ){
        try{
            String cname = record.getCname();
            CrouseInfo name = crouseInfoService.selectByName(cname);
            if(name == null){
                return crouseInfoService.insertSelective(record) > 0 ? new Result().successMessage("添加成功",record.getCid()): new Result().error("添加失败");
            }else {
                return new Result().error("课程已存在");
            }
        }catch (Exception e ){
            e.printStackTrace();
            return new Result().error(-1,"添加课程出现异常，请调整参数后重试");
        }
    }

    @ApiOperation(value = "查询特定课程",httpMethod = "GET",response = Result.class,notes = "根据Id查询课程")
    @GetMapping("selectByPrimaryKey")
    public Result selectByPrimaryKey(Integer cid){
        CrouseInfo record = crouseInfoService.selectByPrimaryKey(cid);
        return record == null ? new Result().error("无数据"):new Result().success(record);
    }

    @ApiOperation(value = "更新课程信息",httpMethod = "POST",response = Result.class,notes = "根据Id选择更新课程信息")
    @PostMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@RequestBody CrouseInfo record){
        try {
            return crouseInfoService.updateByPrimaryKeySelective(record) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("修改异常");
        }
    }

    @ApiOperation(value = "更新课程信息",httpMethod = "POST",response = Result.class,notes = "根据Id更新课程信息")
    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody CrouseInfo record){
        try {
            return crouseInfoService.updateByPrimaryKey(record) > 0 ? new Result().successMessage("修改成功"):new Result().error("修改失败");
        }catch (Exception e){
            return new Result().error("修改异常");
        }
    }

    /**
     * 根据课程类别查询课程信息
     * @param kid
     * @return
     */
    @ApiOperation(value = "查询特定课程",httpMethod = "GET",response = Result.class,notes = "根据课程类别查询课程")
    @GetMapping("/selectByKid")
    public Result selectByKid(Integer kid){
        List<CrouseInfo> list = crouseInfoService.selectByKid(kid);
        return list.size() == 0 ? new Result().successMessage("无数据") : new Result().success(list, list.size());
    }

    /**
     * 模糊查询
     * @param cname
     * @return
     */
    @ApiOperation(value = "通过课程名称模糊查询",httpMethod = "GET",response = Result.class,notes = "根据课程名称模糊查询课程")
    @GetMapping("/fuzzyQueryByName")
    public Result fuzzyQueryByName(String cname){
        List<CrouseInfo> list = crouseInfoService.fuzzyQueryByName(cname);
        return list.size() == 0 ? new Result().successMessage("无数据"):new Result().success(list, list.size());
    }

    /**
     * 查询所有课程
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有",httpMethod = "GET",response = Result.class,notes = "查询所有课程（接受页码和页码大小两个参数）")
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<CrouseInfo> list =crouseInfoService.selectAll();
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,crouseInfoService.count());
        }
    }

    @ApiOperation(value = "多条件查询",httpMethod = "GET",response = Result.class,
            notes = "根据课程类别/课程名称/时间/价格/教师名称/学生手机号查询课程（接受页码和页码大小两个参数）")
    @GetMapping("/multiCriteriaQuery")
    public Result multiCriteriaQuery(String kindName, String cname, String beforeDate,
                                     String afterDate, Double price, String tecname, String phone){
        List<CrouseInfo> list = crouseInfoService.multiCriteriaQuery(kindName, cname, beforeDate, afterDate, price, tecname, phone);
        if (list.size() == 0){
            return new Result().successMessage("无数据");
        } else {
            return new Result().success(list,crouseInfoService.counts(kindName, cname, beforeDate, afterDate, price, tecname, phone));
        }
    }

    @ApiOperation(value = "查询特定课程",httpMethod = "GET",response = Result.class,notes = "根据教师名称查询课程")
    @GetMapping("/selectByTecname")
    public Result selectByTecname(String tecname){
        List<CrouseInfo> list = crouseInfoService.selectByTecname(tecname);
        return list.size() == 0 ? new Result().successMessage("无数据") : new Result().success(list, list.size());
    }

    @ApiOperation(value = "查询特定课程",httpMethod = "GET",response = Result.class,notes = "查询推荐课程")
    @GetMapping("/selectByAttribute")
    public Result selectByAttribute(String onchoose){
        List<CrouseInfo> list = crouseInfoService.selectByAttribute("1");
        return list.size() == 0 ? new Result().successMessage("无数据") : new Result().success(list, list.size());
    }
}
