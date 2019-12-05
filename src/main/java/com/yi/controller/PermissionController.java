package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.Permission;
import com.yi.service.PermissionService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perm")
@Api(value = "权限管理业务接口")
public class PermissionController {
    @Autowired
    private PermissionService service;

    @ApiOperation(value = "删除权限",httpMethod = "GET",response = Result.class,notes = "根据Id删除")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     *添加权限
     * @param permission
     * @return
     */
    @ApiOperation(value = "添加权限",httpMethod = "POST",response = Result.class,notes = "添加权限")
    @PostMapping("/insert")
    public Result insert(@RequestBody Permission permission){
        return service.insert(permission) > 0 ? new Result().successMessage("添加成功！"):new Result("添加失败！");
    }

    @ApiOperation(value = "查询特定权限",httpMethod = "GET",response = Result.class,notes = "根据Id查询特定权限")
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id){
        Permission permission = service.selectByPrimaryKey(id);
        if(permission == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(permission);
        }
    }

    @ApiOperation(value = "更新权限信息",httpMethod = "POST",response = Result.class,notes = "根据Id更新权限信息")
    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody Permission permission){
        return service.updateByPrimaryKeySelective(permission) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
    }

    /**
     * 查询所有数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有",httpMethod = "GET",response = Result.class,
            notes = "查询所有权限信息（接受页码和页码大小两个参数）根据名称模糊查询")
    @GetMapping("/selects")
    public Result selects(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize,
                            String title){
        PageHelper.startPage(pageNum,pageSize);
        List<Permission> list =service.selects(title);
        if(list.size() == 0){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,service.counts(title));
        }
    }

}
