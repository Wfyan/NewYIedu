package com.yi.service.impl;

import com.yi.entity.TbReply;
import com.yi.mapper.TbReplyMapper;
import com.yi.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private TbReplyMapper mapper;


    @Override
    public int deleteByPrimaryKey(Integer repId) {
        return mapper.deleteByPrimaryKey(repId);
    }

    @Override
    public int insert(TbReply record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(TbReply record) {
        return mapper.insertSelective(record);
    }

    @Override
    public TbReply selectByPrimaryKey(Integer repId) {
        return mapper.selectByPrimaryKey(repId);
    }

    @Override
    public int updateByPrimaryKeySelective(TbReply record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbReply record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TbReply> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<TbReply> selectByComId(Integer comId) {
        return mapper.selectByComId(comId);
    }

    @Override
    public List<TbReply> selectByStuid(String stuid) {
        return mapper.selectByStuid(stuid);
    }
}
