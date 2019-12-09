package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.Roles;
import com.yi.service.RolesService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/roles")
@Api(value = "角色管理业务接口")
public class RolesController {
    @Autowired
    private RolesService service;

    @ApiOperation(value = "删除",httpMethod = "GET",response = Result.class,notes = "根据Id删除")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     *添加权限
     * @param roles
     * @return
     */
    @ApiOperation(value = "添加",httpMethod = "POST",response = Result.class,notes = "添加")
    @PostMapping("/insert")
    public Result insert(@RequestBody Roles roles){
        return service.insertSelective(roles) > 0 ? new Result().successMessage("添加成功！"):new Result("添加失败！");
    }

    @ApiOperation(value = "根据ID查询",httpMethod = "GET",response = Result.class,notes = "根据ID查询")
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id){
        Roles roles = service.selectByPrimaryKey(id);
        if(roles == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(roles);
        }
    }

    @ApiOperation(value = "根据ID更新",httpMethod = "POST",response = Result.class,notes = "根据ID更新")
    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody Roles roles){
        return service.updateByPrimaryKey(roles) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
    }

    /**
     * 查询所有数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有",httpMethod = "GET",response = Result.class,notes = "查询所有（接受页码和页码大小两个参数）")
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Roles> list =service.selectAll();
        if(list.size() == 0){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

    @ApiOperation(value = "根据名字查询",httpMethod = "GET",response = Result.class,notes = "根据名字查询")
    @GetMapping("/selectByName")
    public Result selectByName(String name){
        Roles roles = service.selectByName(name);
        if (roles == null){
            return new Result().successMessage("无数据");
        } else {
            return new Result().success(roles);
        }
    }

}
