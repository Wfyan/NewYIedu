package com.yi.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.yi.entity.OrderInfo;
import com.yi.entity.TbComment;
import com.yi.service.OrderInfoService;
import com.yi.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orderInfo")
@Api(value = "订单业务接口")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation(value = "删除订单",httpMethod = "GET",response = Result.class,notes = "根据Id删除订单")
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(String orderId){
        return orderInfoService.deleteByPrimaryKey(orderId) > 0 ? new Result().successMessage("删除成功"):new Result("删除失败");
    }

    /**
     * 添加课程
     * @param record
     * @return
     */
    @ApiOperation(value = "添加订单",httpMethod = "POST",response = Result.class,notes = "添加订单")
    @PostMapping("/insertSelective")
    public Result insertOrderInfo(@RequestBody OrderInfo record ){
        try{
            return orderInfoService.insertSelective(record) > 0 ? new Result().successMessage("添加成功"):new Result("添加失败");
        }catch (Exception e ){
            e.printStackTrace();
            return new Result().error(-1,"添加订单出现异常，请调整参数后重试");
        }
    }

    @ApiOperation(value = "查询特定订单",httpMethod = "GET",response = Result.class,notes = "根据Id查询订单")
    @GetMapping("selectByPrimaryKey")
    public Result selectByPrimaryKey(String orderId){
        OrderInfo record = orderInfoService.selectByPrimaryKey(orderId);
        return record == null ? new Result().error("无数据"):new Result().success(record);
    }

    @ApiOperation(value = "更新订单信息",httpMethod = "POST",response = Result.class,notes = "根据Id选择更新订单信息")
    @PostMapping("/updateByPrimaryKeySelective")
    public Result updateByPrimaryKeySelective(@RequestBody OrderInfo record){
        try {
            return orderInfoService.updateByPrimaryKeySelective(record) > 0 ? new Result().successMessage("修改成功"):new Result("修改失败");
        }catch (Exception e){
            e.printStackTrace();
            return new Result().error("修改异常");
        }
    }

    @ApiOperation(value = "更新订单信息",httpMethod = "POST",response = Result.class,notes = "根据Id更新订单信息")
    @PostMapping("/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody OrderInfo record){
        try {
            return orderInfoService.updateByPrimaryKey(record) > 0 ? new Result().successMessage("修改成功"):new Result().error("修改失败");
        }catch (Exception e){
            return new Result().error("修改异常");
        }
    }

    /**
     * 查询所有订单
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询所有",httpMethod = "GET",response = Result.class,notes = "查询所有订单（接受页码和页码大小两个参数）")
    @GetMapping("/selectAll")
    public Result selectAll(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<OrderInfo> list = orderInfoService.selectAll();
        if(list == null){
            return new Result().successMessage("无数据");
        }else{
            return new Result().success(list,orderInfoService.count());
        }
    }

    @ApiOperation(value = "多条件查询",httpMethod = "GET",response = Result.class,
            notes = "根据课程名称/价格/支付状态/时间查询订单（接受页码和页码大小两个参数）")
    @GetMapping("/multiCriteriaQuery")
    public Result multiCriteriaQuery(String cname, Double price, Integer onpay,
                                     String beforeDate, String afterDate, String tecname,
                                     @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<OrderInfo> list = orderInfoService.multiCriteriaQuery(cname, price, onpay, beforeDate, afterDate, tecname);
        if (list.size() == 0){
            return new Result().successMessage("无数据");
        } else {
            return new Result().success(list,orderInfoService.counts(cname, price, onpay, beforeDate, afterDate, tecname));
        }
    }

    @ApiOperation(value = "支付宝支付",httpMethod = "Post",response = Result.class, notes = "支付宝支付")
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Result order(OrderInfo record) {
        return new Result(orderInfoService.order(record));
    }
}
