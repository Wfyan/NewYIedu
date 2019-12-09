package com.yi.service.impl;

import com.yi.entity.RolePermission;
import com.yi.mapper.RolePermissionMapper;
import com.yi.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
   @Autowired
    private RolePermissionMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer rolePermissionId) {
        return mapper.deleteByPrimaryKey(rolePermissionId);
    }

    @Override
    public int insert(RolePermission record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(RolePermission record) {
        return mapper.insertSelective(record);
    }

    @Override
    public RolePermission selectByPrimaryKey(Integer rolePermissionId) {
        return mapper.selectByPrimaryKey(rolePermissionId);
    }

    @Override
    public int updateByPrimaryKeySelective(RolePermission record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RolePermission record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<RolePermission> selectByRoleId(Integer roleId) {
        return mapper.selectByRoleId(roleId);
    }

    @Override
    public int countByRoleId(Integer roleId) {
        return mapper.countByRoleId(roleId);
    }
}
