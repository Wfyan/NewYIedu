package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.dto.KindInfoQueryCriteria;
import com.yi.entity.KindInfo;
import com.yi.service.KindInfoService;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("KindInfo")
public class KindInfoController {
    @Autowired
    private KindInfoService kindInfoService;

    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(Integer id){
        return kindInfoService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功"):new Result("删除失败");
    }

    /**
     * 添加课程类别
     * @param record
     * @return
     */
    @PostMapping("/insert")
    public Result insertKindInfo(@RequestBody KindInfo record ){
        try{
            String kindName = record.getKindName();
            KindInfo name = kindInfoService.selectByName(kindName);
            if(name == null){
                int n = 0;
                if(record.getLevel()==1){
                    n = kindInfoService.insertSelective(record);
                }else{
                    n = kindInfoService.insert(record);
                }
                if(n > 0) return new Result().successMessage("添加成功"); else return new Result().error("添加失败");
            }else {
                return new Result().error("课程类别已存在");
            }
        }catch (Exception e ){
            e.printStackTrace();
            return new Result().error(-1,"添加类别出现异常，请调整参数后重试");
        }
    }

    @GetMapping("selectByPrimaryKey")
    public Result selectByPrimaryKey(Integer kid){
        KindInfo kindInfo = kindInfoService.selectByPrimaryKey(kid);
        return kindInfo == null ? new Result().error("无数据"):new Result().success(kindInfo);
    }

    @PostMapping("updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody KindInfoQueryCriteria record){
        try {
            return  kindInfoService.updateByPrimaryKey(record) > 0 ?  new Result().successMessage("修改成功"):new Result("修改失败");
        }catch (Exception e){
            return new Result().error("修改异常");
        }
    }

    /**
     * 获取上一级level
     * @param level
     * @return
     */
    @GetMapping("/getHigherLevel")
    public Result getHigherLevel(Integer level){
        List<KindInfo> list = kindInfoService.selectByLevel(level-1);
        if (list.size() == 0){
            return new Result().successMessage("无数据");
        }else {
            return new Result().success(list, list.size());
        }
    }

    /**
     * 根据课程类别查询下一级课程类别
     * @param level
     * @return
     */
    @GetMapping("/selectNextLevel")
    public Result selectNextLevel(Integer level){
        List<KindInfo> list = kindInfoService.selectByLevel(level+1);
        if (list.size() == 0){
            return new Result().successMessage("无数据");
        }else {
            return new Result().success(list, list.size());
        }
    }

    /**
     * 根据课程类别名称查询课程类别
     * @param kindName
     * @return
     */
    @GetMapping("/selectByName")
    public Result selectByName(String kindName){
            KindInfo kindInfo = kindInfoService.selectByName(kindName);
            return kindInfo == null ? new Result().error("无数据"):new Result().success(kindInfo);
    }

    /**
     * 查询所有课程类别
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<KindInfo> list =kindInfoService.selectAll();
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,list.size());
        }
    }

//    public static void main(String[] args) {
//        JSONObject  json =new JSONObject();
//        json.put("a","1");
//        json.put("b",null);
//        Integer a =json.getInteger("a");
//        System.out.println(a);
//        Integer b =json.getInteger("b");
//        System.out.println(b);
//    }

}
