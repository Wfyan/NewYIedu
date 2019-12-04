package com.yi.service;

import com.yi.entity.Permission;

import java.util.List;

public interface PermissionService {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    /**
     * 查询所有数据
     * @return
     */
    List<Permission> selectAll();
}
