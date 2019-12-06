package com.yi.mapper;

import com.yi.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<OrderInfo> selectAll();

    List<OrderInfo> multiCriteriaQuery(@Param("orderId")String orderId, @Param("stuid")String stuid, @Param("cid")Integer cid,
                                       @Param("price")Double price, @Param("onpay")Integer onpay, @Param("addtime")Date addtime);

    int count();
}