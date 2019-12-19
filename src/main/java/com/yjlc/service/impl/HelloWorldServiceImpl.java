package com.yjlc.service.impl;

import com.yjlc.annotation.AnalysisActuator;
import com.yjlc.annotation.Lock;
import com.yjlc.service.HelloWorldService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Liuziyuan on 2019/8/31.
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Lock(LockName = "test")
    public String getHelloMessage(String name) {
        return "Hello " + Optional.ofNullable(name).orElse("World!");
    }

    public static String reverseStr(String s, int k) {
        StringBuffer sb=new StringBuffer();
        for(int i=k;i>=0;i--){
            sb.append(s.charAt(i));
        }
        for(int j=k;j<s.length();j++){
            sb.append(s.charAt(j));
        }
        String countSB=sb.toString();
        return countSB;
    }

    public static void main(String[] args){
        String str="abcdefg";
        int count=2;
        reverseStr(str,count);
    }


}
