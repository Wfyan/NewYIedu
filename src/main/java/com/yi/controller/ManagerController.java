package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.TbManager;
import com.yi.service.ManagerService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/man")
@Api(value = "管理员业务接口")
public class ManagerController {

    @Autowired
    private ManagerService service;

    @ApiOperation(value = "删除管理员",httpMethod = "GET",response = Result.class,notes = "根据Id删除管理员")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     *添加新的管理员
     * @param manager
     * @return
     */
    @ApiOperation(value = "添加管理员",httpMethod = "POST",response = Result.class,notes = "添加管理员")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbManager manager){
        return service.insert(manager) > 0 ? new Result().successMessage("添加成功！"):new Result("添加失败！");
    }

    @ApiOperation(value = "查询特定管理员",httpMethod = "GET",response = Result.class,notes = "根据Id查询管理员")
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id){
        TbManager manager = service.selectByPrimaryKey(id);
        if(manager == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(manager);
        }
    }

    @ApiOperation(value = "更新管理员信息",httpMethod = "POST",response = Result.class,notes = "根据Id更新管理员信息")
    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody TbManager manager){
        return service.updateByPrimaryKeySelective(manager) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
    }

    /**
     * 查询所有数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有",httpMethod = "GET",response = Result.class,notes = "查询所有管理员（接受页码和页码大小两个参数）")
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<TbManager> list =service.selectAll();
        if(list.size() == 0){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,service.counts());
        }
    }

    @ApiOperation(value = "通过手机号查询",httpMethod = "GET",response = Result.class,notes = "根据手机号查询管理员")
    @GetMapping("/selectByPhone")
    public Result selectByPhone(String phone){
        TbManager manager = service.selectByPhone(phone);
        if(manager == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(manager);
        }
    }



}
