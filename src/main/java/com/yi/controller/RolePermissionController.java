package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.RolePermission;
import com.yi.service.RolePermissionService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roleAndPer")
@Api(value = "角色与权限关联的业务逻辑接口")
public class RolePermissionController {
    @Autowired
    private RolePermissionService service;

    @ApiOperation(value = "删除关联",httpMethod = "GET",response = Result.class,notes = "根据Id删除")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     *添加
     * @param rolePermission
     * @return
     */
    @ApiOperation(value = "添加关联",httpMethod = "POST",response = Result.class,notes = "添加")
    @PostMapping("/insert")
    public Result insert(@RequestBody RolePermission rolePermission){
        return service.insert(rolePermission) > 0 ? new Result().successMessage("添加成功！"):new Result("添加失败！");
    }

    @ApiOperation(value = "查询特定信息",httpMethod = "GET",response = Result.class,notes = "根据Id查询")
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id){
        RolePermission rolePermission = service.selectByPrimaryKey(id);
        if(rolePermission == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(rolePermission);
        }
    }

    @ApiOperation(value = "更新信息",httpMethod = "POST",response = Result.class,notes = "根据ID更新")
    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody RolePermission rolePermission){
        return service.updateByPrimaryKey(rolePermission) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
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
        List<RolePermission> list =service.selectAll();
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

    /**
     * 根据角色查询相关的权限
     * @param pageNum
     * @param pageSize
     * @param roleId
     * @return
     */
    @ApiOperation(value = "查询某角色相关的权限信息",httpMethod = "GET",response = Result.class,
            notes = "根据角色ID查询其拥有的权限（接受页码和页码大小两个参数）")
    @GetMapping("/selectByRoleId")
    public Result selectByRoleId(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize,int roleId){
        PageHelper.startPage(pageNum,pageSize);
        List<RolePermission> list =service.selectByRoleId(roleId);
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

}
