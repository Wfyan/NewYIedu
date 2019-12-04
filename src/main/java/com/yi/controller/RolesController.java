package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.Roles;
import com.yi.service.RolesService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RolesService service;

    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     *添加权限
     * @param roles
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody Roles roles){
        return service.insert(roles) > 0 ? new Result().successMessage("添加成功！"):new Result("添加失败！");
    }

    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id){
        Roles roles = service.selectByPrimaryKey(id);
        if(roles == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(roles);
        }
    }

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
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Roles> list =service.selectAll();
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

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
