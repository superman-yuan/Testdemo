package com.yjlc.controller;


import com.yjlc.api.HttpKit;
import com.yjlc.api.Tip;
import com.yjlc.entity.Seckill;
import com.yjlc.service.SeckillService;
import com.yjlc.utill.JsonUtil;
import com.yjlc.utill.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 *
 * Created by dashang001 on 2018/7/25.
 */
@RestController
@RequestMapping("/Seckil")
public class SeckillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeckillController.class);
    @Resource
    SeckillService seckillService;
    @RequestMapping(value = "/getById" ,method = RequestMethod.GET)
    public Tip<Seckill> getById(Long id){
        LOGGER.info("开始获取列表");
        Seckill seckill= null;
        try {
            seckill = seckillService.getById(id);
            if (seckill!=null){
                LOGGER.info(JsonUtil.objStringPretty(seckill));
                LOGGER.info("获取结束");
                return HttpKit.success(seckill);
            }
            return HttpKit.failed("id不正确请重试");
        } finally {
            LOGGER.info("获取失败");
        }

    }
}