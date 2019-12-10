package com.yi.service;

import com.yi.entity.VideoInfo;

import java.util.List;

public interface VideoInfoService {
    int deleteByPrimaryKey(Integer vid);

    int insert(VideoInfo record);

    int insertSelective(VideoInfo record);

    VideoInfo selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(VideoInfo record);

    int updateByPrimaryKey(VideoInfo record);

    List<VideoInfo> fuzzyQueryByName(String title);    //模糊查询

    List<VideoInfo> selectAll();

    List<VideoInfo> selectByCid(Integer cid);
}
