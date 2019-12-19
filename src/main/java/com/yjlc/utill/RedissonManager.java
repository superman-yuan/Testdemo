package com.yjlc.utill;

import com.sun.org.apache.regexp.internal.RE;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by Liuziyuan on 2019/9/7.
 */
//@Configuration
//@Component
public class RedissonManager {

    private static Config config = new Config();

    private static Redisson redisson=null;

//    @Value("${spring.datasource.name.db}")
    public static String RedisAddress="139.196.96.65:6379";

//    public RedissonManager(){
//        this.RedisAddress=RedisAddres;
//    }

    public static Redisson getRedisson(){
        config.useSingleServer().setAddress(RedisAddress);
        if(redisson!=null){
            redisson = (Redisson) Redisson.create(config);
        }
        return redisson;
    }

}//9