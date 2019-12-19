package com.yjlc.dao;

import com.yjlc.entity.bbsUser;

public interface bbsUserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(bbsUser record);

    int insertSelective(bbsUser record);

    bbsUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(bbsUser record);

    int updateByPrimaryKey(bbsUser record);
}