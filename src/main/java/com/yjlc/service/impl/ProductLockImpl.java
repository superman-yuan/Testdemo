package com.yjlc.service.impl;

import com.yjlc.dao.ProductLockMapper;
import com.yjlc.service.ProductLock;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liuziyuan on 2019/9/11.
 */
@Service
@Slf4j
public class ProductLockImpl extends Thread implements ProductLock {

    @Autowired
    ProductLockMapper productLockMapper;

    @Autowired
    RedisTemplate redisTemplate;

    Integer count = 0;
    Integer stock=0;

    @Override
    @Async("taskExecutor")
        public synchronized boolean updateProduct(com.yjlc.entity.ProductLock productLock) {

        if(!redisTemplate.opsForValue().get("logo").equals(null)){
            return false;
        }
//        redisTemplate.delete(productLock.getId());
        com.yjlc.entity.ProductLock productLockE;
        Object productRedisKey=redisTemplate.opsForValue().get(productLock.getId());
         productLockE=(com.yjlc.entity.ProductLock)
                JSONObject.toBean(JSONObject.fromObject(productRedisKey),
                com.yjlc.entity.ProductLock.class);
        stock=productLockE.getStock();
        if(productLockE==null||productLockE.getStock()==0){
            log.info("执行位置={}","添加查询redis缓存");
            productLockE=productLockMapper.selectByPrimaryKey(productLock.getId());
            if(productLockE.getStock()!=0){
                redisTemplate.opsForValue().set(productLockE.getId(),productLockE,60*10, TimeUnit.SECONDS);
                stock=productLockE.getStock();
            }
        }
        count++;
        log.info("执行位置={}","查看库存剩余量"+productLockE.getStock());
        if(productLock.getStock()<=productLockE.getStock()&&productLockE.getStock()!=0){
            Integer productNumE=productLockE.getStock();
            Integer product=productNumE-productLock.getStock();
            productLock.setStock(product);
            log.info("执行位置={}","修改redis缓存");
            redisTemplate.opsForValue().set(productLockE.getId(),productLock);
            return true;
        }else{
                int countStock=productLockMapper.updateByPrimaryKeySelective(productLockE);
                redisTemplate.delete(productLockE.getId());
                if(countStock>0){
                    log.info("执行位置={}","开始修改数据库并修改完成");
                    redisTemplate.opsForValue().set("logo",1,30,TimeUnit.SECONDS);
                }

        }
        return false;
    }

    @Override
    public List<com.yjlc.entity.ProductLock> selectProductList() {
        return productLockMapper.selectProductLock();
    }


    @Override
    public void run() {
        super.run();
    }
}
