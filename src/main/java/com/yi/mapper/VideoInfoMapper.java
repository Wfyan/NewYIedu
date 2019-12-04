package com.yi.mapper;

import com.yi.entity.VideoInfo;

import java.util.List;

public interface VideoInfoMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(VideoInfo record);

    int insertSelective(VideoInfo record);

    VideoInfo selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(VideoInfo record);

    int updateByPrimaryKey(VideoInfo record);

    List<VideoInfo> fuzzyQueryByName(String title);    //模糊查询

    List<VideoInfo> selectAll();

}