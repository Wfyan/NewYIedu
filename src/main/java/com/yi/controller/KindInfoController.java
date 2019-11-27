package com.yi.controller;

import com.alibaba.fastjson.JSONObject;
import com.yi.service.KindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("KindInfo")
public class KindInfoController {
    @Autowired
    private KindInfoService kindInfoService;

    @ResponseBody
    @RequestMapping("/addKindInfo")
    public JSONObject addKindInfo(@RequestBody  JSONObject json ){
        JSONObject jsResult = new JSONObject();
        try{
            String kindName=json.getString("kindName");
            Integer higherId=json.getInteger("higherId");
            Integer level=json.getInteger("level");
            //   if(level == null || "".equals(level)){}
            int flag = kindInfoService.insert(kindName, higherId, level);
            if(flag ==1){
                jsResult.put("errCode","0");
                jsResult.put("errMsg","添加类别成功");
            }else{
                jsResult.put("errCode","-2");
                jsResult.put("errMsg","添加类别失败");
            }

        }catch (Exception e ){
            jsResult.put("errCode","-1");
            jsResult.put("errMsg","添加类别出现异常，请调整参数后重试");
        }
            return jsResult;

    }

    @RequestMapping("/getHigherLevel")
    public List<Integer> getHigherLevel(Integer level){
        //获取上一级level
        return  kindInfoService.selectHigher(level);
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
