package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.Permission;
import com.yi.service.PermissionService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perm")
public class PermissionController {
    @Autowired
    private PermissionService service;

    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     *添加权限
     * @param permission
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody Permission permission){
        return service.insert(permission) > 0 ? new Result().successMessage("添加成功！"):new Result("添加失败！");
    }

    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id){
        Permission permission = service.selectByPrimaryKey(id);
        if(permission == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(permission);
        }
    }

    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody Permission permission){
        return service.updateByPrimaryKey(permission) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
    }

    /**
     * 查询所有数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Permission> list =service.selectAll();
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }


}
