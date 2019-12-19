package com.yjlc.service.impl;

import com.yjlc.dao.SeckillMapper;
import com.yjlc.entity.Seckill;
import com.yjlc.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dashang001 on 2018/7/25.
 */

@Service
public class SeckillServiceImpl implements SeckillService{
    @Resource
    SeckillMapper seckillMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(SeckillServiceImpl.class);
    @Override
    public Seckill getById(Long id) {
        String str="123";
        int i=Integer.valueOf(str);
      return seckillMapper.selectByPrimaryKey(id);
    }
    public static int[] qc(int[] ints){
        int count=0;
        for (int i=0;i<ints.length;i++){
            if (ints[count]!=ints[i]){
                count++;
                ints[count]=ints[i];
            }
        }
        return ints;
    }
    public static int[] twoSum(int[] nums, int target) {
        int count=0;
        int[] index = new int[0];
        for(int i=1;i<nums.length;i++){
            if(nums[count]+nums[i]==target){
                index = new int[]{count, i};
            }
            if(nums[count]+nums[i]!=target){
                count++;
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[] ints={1,2,3,1};
        int[] ints1=SeckillServiceImpl.twoSum(ints,5);
    }
}