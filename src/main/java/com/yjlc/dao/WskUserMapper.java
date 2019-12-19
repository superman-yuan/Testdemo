package com.yjlc.dao;

import com.yjlc.entity.WskUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

@Mapper
//@CacheConfig(cacheNames = "wsk_user")
public interface WskUserMapper {
        int deleteByPrimaryKey(Integer id);

    int insert(WskUser record);

    int insertSelective(WskUser record);
    //    @Select("select id, name, phone, password, age, gender, remark, lcon,signature from user where phone =#{phone}")
//    @Cacheable(key ="#p0")
    WskUser selectByPrimaryKey(@Param( "phone" ) String phone);

    int updateByPrimaryKeySelective(WskUser record);

    int updateByPrimaryKeyWithBLOBs(WskUser record);

    int updateByPrimaryKey(WskUser record);
}