package com.yjlc.dao;

import com.yjlc.entity.ProductLock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductLockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductLock record);

    int insertSelective(ProductLock record);

    ProductLock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductLock record);

    int updateByPrimaryKey(ProductLock record);

    List<ProductLock> selectProductLock();
}