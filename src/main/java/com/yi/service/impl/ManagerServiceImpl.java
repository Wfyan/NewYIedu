package com.yi.service.impl;

import com.yi.entity.TbManager;
import com.yi.mapper.TbManagerMapper;
import com.yi.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private TbManagerMapper mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TbManager record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(TbManager record) {
        return 0;
    }

    @Override
    public TbManager selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TbManager record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbManager record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TbManager> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public TbManager getByName(String userName) {
        return mapper.getByName(userName);
    }

    @Override
    public TbManager goLogin(String name, String password) {
        return mapper.goLogin(name,password);
    }

    @Override
    public TbManager selectByPhone(String phone) {
        return mapper.selectByPhone(phone);
    }
}
