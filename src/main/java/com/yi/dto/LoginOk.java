package com.yi.dto;

import com.yi.entity.Permission;
import com.yi.entity.RolePermission;

import java.util.List;

public class LoginOk {
    String id;
    String name;
    int roleId;
    List<RolePermission> list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public List<RolePermission> getList() {
        return list;
    }

    public void setList(List<RolePermission> list) {
        this.list = list;
    }
}
