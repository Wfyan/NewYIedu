package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.TbReply;
import com.yi.service.ReplyService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reply")
@Api(value = "回复管理业务接口")
public class ReplyController {
    @Autowired
    private ReplyService service;

    @ApiOperation(value = "删除",httpMethod = "GET",response = Result.class,notes = "根据Id删除")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id){
        return service.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功！"):new Result("删除失败！");
    }

    /**
     * 发表评论
     * @param reply
     * @return
     */
    @ApiOperation(value = "发表回复",httpMethod = "POST",response = Result.class,notes = "添加")
    @PostMapping("/insert")
    public Result insert(@RequestBody TbReply reply){
        return service.insertSelective(reply) > 0 ? new Result().successMessage("回复成功！"):new Result("回复失败！");
    }

    @ApiOperation(value = "根据ID查询",httpMethod = "GET",response = Result.class,notes = "根据ID查询")
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id){
        TbReply reply = service.selectByPrimaryKey(id);
        if(reply == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(reply);
        }
    }

    @ApiOperation(value = "根据ID更新",httpMethod = "POST",response = Result.class,notes = "根据ID更新")
    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody TbReply reply){
        return service.updateByPrimaryKey(reply) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
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
        List<TbReply> list =service.selectAll();
        if(list.size() == 0){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

    /**
     * 查询某个评论下的所有回复
     * @param pageNum
     * @param pageSize
     * @param comId
     * @return
     */
    @ApiOperation(value = "查询某个评论下的所有回复",httpMethod = "GET",response = Result.class,
            notes = "查询某个评论下的所有回复（接受页码和页码大小两个参数）")
    @GetMapping("/selectByComId")
    public Result selectByComId(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize,int comId){
        PageHelper.startPage(pageNum,pageSize);
        List<TbReply> list =service.selectByComId(comId);
        if(list.size() == 0){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }
    

}
