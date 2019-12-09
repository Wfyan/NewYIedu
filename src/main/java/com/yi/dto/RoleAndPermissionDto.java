package com.yi.dto;

import com.yi.entity.Permission;
import com.yi.entity.TbReply;

import java.util.Date;
import java.util.List;

public class RoleAndPermissionDto {
    private Integer rolePermissionId;

    private Integer roleId;

    private Integer permissionId;

    //权限列表
    List<Permission> list;

    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Integer rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public List<Permission> getList() {
        return list;
    }

    public void setList(List<Permission> list) {
        this.list = list;
    }
}
