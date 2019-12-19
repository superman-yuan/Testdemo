package com.yjlc.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Liuziyuan on 2019/9/11.
 */
public interface ProductLock {
    /**
     * 更新库存
     * @param productLock
     * @return
     */
    boolean updateProduct(com.yjlc.entity.ProductLock productLock);

    /**
     * 查询产品
     * @return
     */
    List<com.yjlc.entity.ProductLock> selectProductList();

}
