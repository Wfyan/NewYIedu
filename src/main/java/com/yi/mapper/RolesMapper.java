package com.yi.mapper;

import com.yi.entity.Roles;
import org.apache.ibatis.annotations.Param;

import javax.management.relation.Role;
import java.util.List;

public interface RolesMapper {
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
    Roles selectByName(@Param("name") String name);
}