package com.yi.controller;

import com.yi.entity.VideoInfo;
import com.yi.service.VideoInfoService;
import com.yi.util.FileUploadTool;
import com.yi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/videoInfo")
public class VideoInfoController {

    @Autowired
    private VideoInfoService videoInfoService;

    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(Integer vid){
        try {
            return videoInfoService.deleteByPrimaryKey(vid) > 0 ? new Result().successMessage("删除成功"):new Result("删除失败");
        }catch (Exception e){
            return new Result().error("删除异常");
        }
    }

    @RequestMapping(value = "/upload", method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Result insert(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
                         HttpServletRequest request,VideoInfo record) {
//        String message = "";
        String  url = upload(multipartFile, request);
        record.setVurl(url);
        return videoInfoService.insert(record)> 0 ? new Result().successMessage("添加成功") : new Result().error("添加失败");
    }

    public String  upload(MultipartFile multipartFile, HttpServletRequest request){
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

    @GetMapping("selectByPrimaryKey")
    public Result selectByPrimaryKey(Integer vid){
        VideoInfo record = videoInfoService.selectByPrimaryKey(vid);
        return record == null ? new Result().successMessage("无数据"):new Result().success(record);
    }

    @PostMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@RequestBody VideoInfo record){
        try {
            return videoInfoService.updateByPrimaryKeySelective(record) > 0 ? new Result().successMessage("修改成功"):new Result().error("修改失败");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("修改异常");
        }
    }

    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody VideoInfo record){
        try {
            return videoInfoService.updateByPrimaryKey(record) > 0 ? new Result().successMessage("修改成功"):new Result().error("修改失败");
        }catch (Exception e){
            return new Result().error("修改异常");
        }
    }
}
