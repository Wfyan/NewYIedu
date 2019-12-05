package com.yi.mapper;

import com.yi.entity.TbManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbManager record);

    int insertSelective(TbManager record);

    TbManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbManager record);

    int updateByPrimaryKey(TbManager record);

    /**
     * 查询所有数据
     * @return
     */
    List<TbManager> selectAll();

    /**
     * 根据用户名获取信息
     * @param userName
     * @return
     */
    TbManager getByName(@Param("userName") String userName);
    /**
     * 根据账号密码获取信息（用于登录）
     * @param name
     * @param password
     * @return
     */
    TbManager goLogin(@Param("name") String name, @Param("password") String password);
    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    TbManager selectByPhone(@Param("phone") String phone);
    /**
     * 统计总数，用于分页
     * @return
     */
    int counts();
}