package com.yjlc.thread;

import com.yjlc.service.ProductLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by Liuziyuan on 2019/9/12.
 */
@Component
@Scope("prototype")//spring 多例
public class DBThread implements Runnable {
    private String msg;
    private Integer id;
    private Integer stock;
    private Logger log = LoggerFactory.getLogger(DBThread.class);

//    @Autowired
//    SystemLogService systemLogService;
    @Autowired
    ProductLock productLockS;


    @Override
    public void run() {
        com.yjlc.entity.ProductLock productLock = new com.yjlc.entity.ProductLock();
        productLock.setId(id);
        productLock.setVersion(2);
        productLock.setStock(stock);
        productLockS.updateProduct(productLock);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
