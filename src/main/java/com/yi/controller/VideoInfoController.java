package com.yi.controller;

import com.github.pagehelper.PageHelper;
import com.yi.entity.VideoInfo;
import com.yi.service.VideoInfoService;
import com.yi.util.FileUploadTool;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/videoInfo")
@Api(value = "视频业务接口")
public class VideoInfoController {

    @Autowired
    private VideoInfoService videoInfoService;

    @ApiOperation(value = "删除视频",httpMethod = "GET",response = Result.class,notes = "根据Id删除视频")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(Integer vid){
        try {
            return videoInfoService.deleteByPrimaryKey(vid) > 0 ? new Result().successMessage("删除成功"):new Result("删除失败");
        }catch (Exception e){
            return new Result().error("删除异常");
        }
    }

    @ApiOperation(value = "上传视频",httpMethod = "POST",response = Result.class,notes = "上传视频")
    @RequestMapping(value = "/upload", method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result insert(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
                         HttpServletRequest request,VideoInfo record) {
//        String message = "";
        String  url = upload(multipartFile, request);
        record.setVurl(url);
        return videoInfoService.insertSelective(record)> 0 ? new Result().successMessage("添加成功") : new Result().error("添加失败");
    }

    public String upload(MultipartFile multipartFile, HttpServletRequest request){
        FileUploadTool fileUploadTool = new FileUploadTool();
        try {
            String url = fileUploadTool.createFile(multipartFile, request);
            if (url != null) {
//                service.saveFile(entity);
//                message = "上传成功";
//                map.put("entity", entity);
//                map.put("result", message);
                return url;
            } else {
//                message = "上传失败";
//                map.put("result", message);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ApiOperation(value = "查询特定视频",httpMethod = "GET",response = Result.class,notes = "根据Id查询视频")
    @GetMapping("selectByPrimaryKey")
    public Result selectByPrimaryKey(Integer vid){
        VideoInfo record = videoInfoService.selectByPrimaryKey(vid);
        return record == null ? new Result().successMessage("无数据"):new Result().success(record);
    }

    @ApiOperation(value = "更新视频信息",httpMethod = "POST",response = Result.class,notes = "根据Id选择更新视频信息")
    @PostMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@RequestBody VideoInfo record){
        try {
            return videoInfoService.updateByPrimaryKeySelective(record) > 0 ? new Result().successMessage("修改成功"):new Result().error("修改失败");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("修改异常");
        }
    }

    @ApiOperation(value = "更新视频信息",httpMethod = "POST",response = Result.class,notes = "根据Id更新视频信息")
    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody VideoInfo record){
        try {
            return videoInfoService.updateByPrimaryKey(record) > 0 ? new Result().successMessage("修改成功"):new Result().error("修改失败");
        }catch (Exception e){
            return new Result().error("修改异常");
        }
    }

    /**
     * 模糊查询
     * @param title
     * @return
     */
    @ApiOperation(value = "通过视频名称模糊查询",httpMethod = "GET",response = Result.class,notes = "根据视频名称模糊查询视频")
    @GetMapping("/fuzzyQueryByName")
    public Result fuzzyQueryByName(String title){
        List<VideoInfo> list = videoInfoService.fuzzyQueryByName(title);
        return list.size() == 0 ? new Result().successMessage("无数据"):new Result().success(list, list.size());
    }

    /**
     * 查询所有视频
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有",httpMethod = "GET",response = Result.class,notes = "查询所有视频（接受页码和页码大小两个参数）")
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<VideoInfo> list =videoInfoService.selectAll();
        if(list == null){
            return new Result().successMessage("无视频");
        }else{
            return new Result().success(list,list.size());
        }
    }

    @ApiOperation(value = "查询特定视频",httpMethod = "GET",response = Result.class,notes = "根据课程id查询视频")
    @GetMapping("/selectByCid")
    public Result selectByCid(Integer cid, @RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<VideoInfo> list =videoInfoService.selectByCid(cid);
        if(list == null){
            return new Result().successMessage("无视频");
        }else{
            return new Result().success(list,list.size());
        }
    }
}
