package com.yjlc.controller;

import com.yjlc.api.HttpKit;
import com.yjlc.api.Tip;
import com.yjlc.entity.ProductLock;
import com.yjlc.thread.ThreadPoolManager;
import com.yjlc.utill.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liuziyuan on 2019/9/11.
 */
@RestController
@RequestMapping("/ProductLock/")public class ProductLockController {

    @Autowired
    ThreadPoolManager tpm;

    @Autowired
    com.yjlc.service.ProductLock productLockService;

    @RequestMapping("buyAProduct")
    public Tip buyAProduct(){
        ProductLock productLock = new ProductLock();
        productLock.setId(1);
        productLock.setStock(1);
        productLock.setProductNo("10010");
        productLock.setVersion(2);
        if(productLock.getId()==null){
            return HttpKit.failed("产品详情不能为空！");
        }
        productLockService.updateProduct(productLock);
            return HttpKit.success();

//        return HttpKit.failed("未知错误！");
    }
}
