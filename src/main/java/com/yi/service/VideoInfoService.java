package com.yi.service;

import com.yi.entity.VideoInfo;

public interface VideoInfoService {
    int deleteByPrimaryKey(Integer vid);

    int insert(VideoInfo record);

    int insertSelective(VideoInfo record);

    VideoInfo selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(VideoInfo record);

    int updateByPrimaryKey(VideoInfo record);
}
