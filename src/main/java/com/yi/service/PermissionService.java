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
    List<Permission> selects(String title);
    /**
     * 统计总数，用于分页
     * @param title
     * @return
     */
    int counts(String title);
    /**
     * 根据角色ID查询相关权限
     * @param roleId
     * @return
     */
    List<Permission> selectByLevel(Integer roleId);
}
