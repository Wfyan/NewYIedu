package com.yi.service.impl;

import com.yi.entity.VideoInfo;
import com.yi.mapper.VideoInfoMapper;
import com.yi.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoInfoServiceImpl implements VideoInfoService {

    @Autowired
    private VideoInfoMapper videoInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer vid) {
        return videoInfoMapper.deleteByPrimaryKey(vid);
    }

    @Override
    public int insert(VideoInfo record) {
        return videoInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(VideoInfo record) {
        return videoInfoMapper.insertSelective(record);
    }

    @Override
    public VideoInfo selectByPrimaryKey(Integer vid) {
        return videoInfoMapper.selectByPrimaryKey(vid);
    }

    @Override
    public int updateByPrimaryKeySelective(VideoInfo record) {
        return videoInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(VideoInfo record) {
        return videoInfoMapper.updateByPrimaryKey(record);
    }
}
