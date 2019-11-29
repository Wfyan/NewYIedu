package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.TbStudent;
import com.yi.service.impl.StudentServiceImpl;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl service;

    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     *添加新的管理员
     * @param student
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody TbStudent student){
        student.setStuid("1");
        return service.insertSelective(student) > 0 ? new Result().successMessage("添加成功！"):new Result("添加失败！");
    }

    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id){
        TbStudent student = service.selectByPrimaryKey(id);
        if(student == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(student);
        }
    }

    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody TbStudent student){
        return service.updateByPrimaryKey(student) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
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
        List<TbStudent> list =service.selectAll();
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

    @GetMapping("/selectByPhone")
    public Result selectByPhone(String phone){
        TbStudent student = service.selectByPhone(phone);
        if(student == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(student);
        }
    }



}
