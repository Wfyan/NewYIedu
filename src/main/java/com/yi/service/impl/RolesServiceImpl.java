package com.yi.service.impl;

import com.yi.entity.Roles;
import com.yi.mapper.RolesMapper;
import com.yi.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return mapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insert(Roles record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Roles record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Roles selectByPrimaryKey(Integer roleId) {
        return selectByPrimaryKey(roleId);
    }

    @Override
    public int updateByPrimaryKeySelective(Roles record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Roles record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Roles> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public Roles selectByName(String name) {
        return mapper.selectByName(name);
    }
}
