package com.yi.service.impl;

import com.yi.entity.TbStudent;
import com.yi.mapper.TbStudentMapper;
import com.yi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private TbStudentMapper mapper;

    @Override
    public int deleteByPrimaryKey(String stuid) {
        return mapper.deleteByPrimaryKey(stuid);
    }

    @Override
    public int insert(TbStudent record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(TbStudent record) {
        return mapper.insertSelective(record);
    }

    @Override
    public TbStudent selectByPrimaryKey(String stuid) {
        return mapper.selectByPrimaryKey(stuid);
    }

    @Override
    public int updateByPrimaryKeySelective(TbStudent record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbStudent record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TbStudent> getByName(String stuname) {
        return mapper.getByName(stuname);
    }

    @Override
    public TbStudent goLoginByPhone(String phone, String stupassword) {
        return mapper.goLoginByPhone(phone,stupassword);
    }

    @Override
    public TbStudent selectByPhone(String phone) {
        return mapper.selectByPhone(phone);
    }

    @Override
    public List<TbStudent> selects(Integer state, String phone, String beforeDate, String afterDate) {
        return mapper.selects(state,phone,beforeDate,afterDate);
    }

    @Override
    public int counts(Integer state, String beforeDate, String afterDate) {
        return mapper.counts(state,beforeDate,afterDate);
    }
}
