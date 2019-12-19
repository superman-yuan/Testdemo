package com.yjlc.dao;

import com.yjlc.entity.OpeningWeekTime;

public interface OpeningWeekTimeMapper {
    int deleteByPrimaryKey(Integer subscribeTimeId);

    int insert(OpeningWeekTime record);

    int insertSelective(OpeningWeekTime record);

    OpeningWeekTime selectByPrimaryKey(Integer subscribeTimeId);

    int updateByPrimaryKeySelective(OpeningWeekTime record);

    int updateByPrimaryKey(OpeningWeekTime record);
}