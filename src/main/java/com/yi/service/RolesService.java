package com.yi.service;

import com.yi.entity.Roles;

import java.util.List;

public interface RolesService {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Roles record);

    int insertSelective(Roles record);

    Roles selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Roles record);

    int updateByPrimaryKey(Roles record);
    /**
     * 查询所有数据
     * @return
     */
    List<Roles> selectAll();
    /**
     * 根据名称查询所有数据
     * @return
     */
    Roles selectByName(String name);
}
