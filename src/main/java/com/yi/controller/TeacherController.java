package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.TbTeacher;
import com.yi.service.TeacherService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(value = "教生管理业务接口")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @ApiOperation(value = "删除",httpMethod = "GET",response = Result.class,notes = "根据ID删除")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     *添加新的管理员
     * @param teacher
     * @return
     */
    @ApiOperation(value = "添加",httpMethod = "POST",response = Result.class,notes = "添加")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbTeacher teacher){
        teacher.setTecid("1");
        return service.insertSelective(teacher) > 0 ? new Result().successMessage("添加成功！"):new Result("添加失败！");
    }

    @ApiOperation(value = "根据ID查询",httpMethod = "GET",response = Result.class,notes = "根据ID查询")
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id){
        TbTeacher teacher = service.selectByPrimaryKey(id);
        if(teacher == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(teacher);
        }
    }

    @ApiOperation(value = "根据ID更新",httpMethod = "POST",response = Result.class,notes = "根据ID更新")
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
    @ApiOperation(value = "查询所有",httpMethod = "GET",response = Result.class,notes = "查询所有（接受页码和页码大小两个参数）")
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<TbTeacher> list =service.selectAll();
        if(list.size() == 0){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

    @ApiOperation(value = "根据手机号查询",httpMethod = "GET",response = Result.class,notes = "根据手机号查询特定学生")
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
