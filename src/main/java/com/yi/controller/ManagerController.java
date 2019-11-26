package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.TbManager;
import com.yi.service.impl.ManagerServiceImpl;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/man")
public class ManagerController {

    @Autowired
    private ManagerServiceImpl service;

    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     *添加新的管理员
     * @param manager
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody TbManager manager){
        return service.insert(manager) > 0 ? new Result().successMessage("添加成功！"):new Result("添加失败！");
    }

    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id){
        TbManager manager = service.selectByPrimaryKey(id);
        if(manager == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(manager);
        }
    }

    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody TbManager manager){
        return service.updateByPrimaryKey(manager) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
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
        List<TbManager> list =service.selectAll();
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

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
