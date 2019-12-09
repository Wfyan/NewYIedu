package com.yi.mapper;

import com.yi.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 根据角色ID查询相关权限
     * @param roleId
     * @return
     */
    List<Permission> selectByLevel(@Param("roleId") Integer roleId);

    /**
     * 根据状态查询所有
     * @param title
     * @return
     */
    List<Permission> selects(@Param("title") String title);

    /**
     * 统计总数，用于分页
     * @param title
     * @return
     */
    int counts(@Param("title") String title);

}