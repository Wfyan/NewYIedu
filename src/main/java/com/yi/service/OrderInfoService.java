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

    List<OrderInfo> multiCriteriaQuery(String cname, Double price, Integer onpay,
                                       String beforeDate, String afterDate, String tecname);

    int count();

    int counts(String cname, Double price, Integer onpay, String beforeDate, String afterDate, String tecname);
}
