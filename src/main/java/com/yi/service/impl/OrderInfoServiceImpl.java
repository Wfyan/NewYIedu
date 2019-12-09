package com.yi.service.impl;

import com.yi.entity.OrderInfo;
import com.yi.mapper.OrderInfoMapper;
import com.yi.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return orderInfoMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(OrderInfo record) {
        return orderInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderInfo record) {
        return orderInfoMapper.insertSelective(record);
    }

    @Override
    public OrderInfo selectByPrimaryKey(String orderId) {
        return orderInfoMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<OrderInfo> selectAll() {
        return orderInfoMapper.selectAll();
    }

    @Override
    public List<OrderInfo> multiCriteriaQuery(String cname, Double price, Integer onpay,
                                              String beforeDate, String afterDate, String tecname) {
        return orderInfoMapper.multiCriteriaQuery(cname, price, onpay, beforeDate, afterDate, tecname);
    }

    @Override
    public int count() {
        return orderInfoMapper.count();
    }

    @Override
    public int counts(String cname, Double price, Integer onpay, String beforeDate, String afterDate, String tecname) {
        return orderInfoMapper.counts(cname, price, onpay, beforeDate, afterDate, tecname);
    }
}
