package com.yi.service.impl;

import com.yi.entity.TbTeacher;
import com.yi.mapper.TbTeacherMapper;
import com.yi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TbTeacherMapper mapper;

    @Override
    public int deleteByPrimaryKey(String tecid) {
        return mapper.deleteByPrimaryKey(tecid);
    }

    @Override
    public int insert(TbTeacher record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(TbTeacher record) {
        return mapper.insertSelective(record);
    }

    @Override
    public TbTeacher selectByPrimaryKey(String tecid) {
        return mapper.selectByPrimaryKey(tecid);
    }

    @Override
    public int updateByPrimaryKeySelective(TbTeacher record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbTeacher record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TbTeacher> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<TbTeacher> getByName(String tecname) {
        return mapper.getByName(tecname);
    }

    @Override
    public TbTeacher goLoginByPhone(String phone, String tecpassword) {
        return mapper.goLoginByPhone(phone,tecpassword);
    }

    @Override
    public TbTeacher selectByPhone(String phone) {
        return mapper.selectByPhone(phone);
    }
}
