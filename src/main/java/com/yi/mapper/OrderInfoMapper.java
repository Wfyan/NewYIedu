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

    List<OrderInfo> multiCriteriaQuery(@Param("cname")String cname, @Param("price")Double price,
                                       @Param("onpay")Integer onpay, @Param("beforeDate") String beforeDate,
                                       @Param("afterDate") String afterDate, @Param("tecname") String tecname);

    int count();

    int counts(@Param("cname")String cname, @Param("price")Double price,
               @Param("onpay")Integer onpay, @Param("beforeDate") String beforeDate,
               @Param("afterDate") String afterDate, @Param("tecname") String tecname);
}