package com.yi.service;

import com.yi.entity.RolePermission;

import java.util.List;

public interface RolePermissionService {
    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    /**
     * 根据角色ID查询所有数据
     * @return
     */
    List<RolePermission> selectByRoleId(Integer roleId);
    /**
     * 统计总数，用于分页
     * @param roleId
     * @return
     */
    int countByRoleId(Integer roleId);
}
