package com.yi.mapper;

import com.yi.entity.KindInfo;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.Map;

>>>>>>> ef0ae44e8159c38773805fbcabcf052098c8ca5f
public interface KindInfoMapper {
    int deleteByPrimaryKey(Integer kid);

    int insert(KindInfo record);

    int insertSelective(KindInfo record);

    KindInfo selectByPrimaryKey(Integer kid);

    int updateByPrimaryKeySelective(KindInfo record);

    int updateByPrimaryKey(KindInfo record);
<<<<<<< HEAD
=======

    List<Integer> selectHigher(Integer level);

    KindInfo selectByName(String name);

    List<KindInfo> selectByHigherId(Integer higherId);

>>>>>>> ef0ae44e8159c38773805fbcabcf052098c8ca5f
}