package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.TbTeacher;
import com.yi.service.impl.TeacherServiceImpl;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl service;

    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     *添加新的管理员
     * @param teacher
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody TbTeacher teacher){
        teacher.setTecid("1");
        return service.insertSelective(teacher) > 0 ? new Result().successMessage("添加成功！"):new Result("添加失败！");
    }

    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id){
        TbTeacher teacher = service.selectByPrimaryKey(id);
        if(teacher == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(teacher);
        }
    }

    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody TbTeacher teacher){
        return service.updateByPrimaryKey(teacher) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
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
        List<TbTeacher> list =service.selectAll();
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

    @GetMapping("/selectByPhone")
    public Result selectByPhone(String phone){
        TbTeacher teacher = service.selectByPhone(phone);
        if(teacher == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(teacher);
        }
    }



}
