package com.yi.service.impl;

import com.yi.entity.TbComment;
import com.yi.mapper.TbCommentMapper;
import com.yi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private TbCommentMapper mapper;


    @Override
    public int deleteByPrimaryKey(Integer comId) {
        return mapper.deleteByPrimaryKey(comId);
    }

    @Override
    public int insert(TbComment record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(TbComment record) {
        return mapper.insertSelective(record);
    }

    @Override
    public TbComment selectByPrimaryKey(Integer comId) {
        return mapper.selectByPrimaryKey(comId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbComment record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbComment record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TbComment> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<TbComment> selectByMultiple(Integer cid, String stuid, String beforeDate, String afterDate) {
        return mapper.selectByMultiple(cid,stuid,beforeDate,afterDate);
    }
}
