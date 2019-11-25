package com.yi.service.impl;

import com.yi.entity.TbStudent;
import com.yi.mapper.TbStudentMapper;
import com.yi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private TbStudentMapper mapper;

    @Override
    public int deleteByPrimaryKey(String stuid) {
        return 0;
    }

    @Override
    public int insert(TbStudent record) {
        return 0;
    }

    @Override
    public int insertSelective(TbStudent record) {
        return 0;
    }

    @Override
    public TbStudent selectByPrimaryKey(String stuid) {
        return mapper.selectByPrimaryKey(stuid);
    }

    @Override
    public int updateByPrimaryKeySelective(TbStudent record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(TbStudent record) {
        return 0;
    }
}
