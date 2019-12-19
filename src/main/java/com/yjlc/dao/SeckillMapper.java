package com.yjlc.dao;

import com.yjlc.entity.Seckill;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SeckillMapper {
    int deleteByPrimaryKey(Long seckillId);

    int insert(Seckill record);

    int insertSelective(Seckill record);

    Seckill selectByPrimaryKey(Long seckillId);

    int updateByPrimaryKeySelective(Seckill record);

    int updateByPrimaryKey(Seckill record);
}