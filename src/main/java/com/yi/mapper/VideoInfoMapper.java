package com.yi.mapper;

import com.yi.entity.VideoInfo;

public interface VideoInfoMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(VideoInfo record);

    int insertSelective(VideoInfo record);

    VideoInfo selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(VideoInfo record);

    int updateByPrimaryKey(VideoInfo record);
}