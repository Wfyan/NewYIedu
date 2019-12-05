package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.TbComment;
import com.yi.service.CommentService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@Api(value = "评论管理业务接口")
public class CommentController {
    @Autowired
    private CommentService service;

    @ApiOperation(value = "删除",httpMethod = "GET",response = Result.class,notes = "根据Id删除")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     * 发表评论
     * @param comment
     * @return
     */
    @ApiOperation(value = "发表评论",httpMethod = "POST",response = Result.class,notes = "添加")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbComment comment){
        return service.insert(comment) > 0 ? new Result().successMessage("发表成功！"):new Result("发表失败！");
    }

    @ApiOperation(value = "根据ID查询",httpMethod = "GET",response = Result.class,notes = "根据ID查询")
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id){
        TbComment comment = service.selectByPrimaryKey(id);
        if(comment == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(comment);
        }
    }

    @ApiOperation(value = "根据ID更新",httpMethod = "POST",response = Result.class,notes = "根据ID更新")
    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody TbComment comment){
        return service.updateByPrimaryKey(comment) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
    }

    /**
     * 查询所有数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有",httpMethod = "GET",response = Result.class,notes = "查询所有（接受页码和页码大小两个参数）")
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize,
                            @RequestParam(defaultValue = "0") int state){
        PageHelper.startPage(pageNum,pageSize);
        List<TbComment> list =service.selectAll(state);
        if(list.size() == 0){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,service.count(state));
        }
    }

    @ApiOperation(value = "组合查询",httpMethod = "GET",response = Result.class,
            notes = "根据课程ID/学生ID/时间组合查询")
    @GetMapping("/selectByMultiple")
    public Result selectByMultiple(@RequestParam(defaultValue = "0") int cid, String stuid,
                                   @RequestParam(defaultValue = "0") int state, String beforeDate, String afterDate){
        List<TbComment> list = service.selectByMultiple(cid,stuid,state,beforeDate,afterDate);
        if (list.size() == 0){
            return new Result().successMessage("无数据");
        } else {
            return new Result().success(list,service.counts(cid,stuid,state,beforeDate,afterDate));
        }
    }

}
