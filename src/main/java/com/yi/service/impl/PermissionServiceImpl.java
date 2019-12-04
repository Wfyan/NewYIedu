package com.yi.service.impl;

import com.yi.entity.Permission;
import com.yi.mapper.PermissionMapper;
import com.yi.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer permissionId) {
        return mapper.deleteByPrimaryKey(permissionId);
    }

    @Override
    public int insert(Permission record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Permission record) {
        return mapper.insertSelective(record);
    }

    @Override
    public Permission selectByPrimaryKey(Integer permissionId) {
        return selectByPrimaryKey(permissionId);
    }

    @Override
    public int updateByPrimaryKeySelective(Permission record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Permission> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<Permission> selectByLevel(Integer roleId) {
        return mapper.selectByLevel(roleId);
    }
}
