package com.yi.service;

import com.yi.entity.OrderInfo;

import java.util.Date;
import java.util.List;

public interface OrderInfoService {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<OrderInfo> selectAll();

    List<OrderInfo> multiCriteriaQuery(String orderId, String stuid, Integer cid, Double price, Integer onpay, Date addtime);

    int count();
}
