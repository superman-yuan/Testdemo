package com.yjlc.dao;

import com.yjlc.entity.Closed;

public interface ClosedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Closed record);

    int insertSelective(Closed record);

    Closed selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Closed record);

    int updateByPrimaryKey(Closed record);
}