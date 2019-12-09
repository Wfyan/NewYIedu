package com.yi.mapper;

import com.yi.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
    /**
     * 查询所有数据
     * @return
     */
    List<RolePermission> selectAll();
    /**
     * 根据角色ID查询所有数据
     * @return
     */
    List<RolePermission> selectByRoleId(@Param("roleId") Integer roleId);
    /**
     * 统计总数，用于分页
     * @param roleId
     * @return
     */
    int countByRoleId(@Param("roleId") Integer roleId);
}