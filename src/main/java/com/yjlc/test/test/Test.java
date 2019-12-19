package com.yjlc.test.test;


import com.yjlc.test.entity.HairFactory;
import org.apache.ibatis.reflection.ArrayUtil;
import org.thymeleaf.util.ArrayUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashSet;

/**
 * Created by lenovo on 2019/2/17.
 */
public class Test {
    public boolean containsDuplicate(int[] nums){
        if(nums.length==1){
            return false;
        }
        int leng=nums.length;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[count]!=nums[i]){
                count++;
                nums[count] =nums[i];


            }
        }
        int a=++count;
        if (a==1){
            a=0;
        }
        if(a==nums.length){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        Test test = new Test();
//        hanoi(3,'A','B','C');
        encode();
        //        System.out.println(test.febonacci(5));
//        Singleton singleton1 = Singleton.getInstance();
//        Singleton singleton2 = Singleton.getInstance();
//        if (singleton1==singleton2){
//            System.out.println("singleton1和singleton2是同一个实例");
//        }else{
//            System.out.println("singleton1和singleton2不是同一个实例");
//        }
//        HairFactory hair = new HairFactory();
//        hair.getHair("left");
    }

    public int febonacci(int i){

        if(i==1||i==2){
            return 1;
        }else{
            int a=febonacci(i-1);
            int b=febonacci(i-2);
            return a+b;
        }
    }

    public static void encode() throws UnsupportedEncodingException {
        String str = URLEncoder.encode("中国","UTF-8");
        System.out.println(str);

        String str1 = URLDecoder.decode(str,"UTF-8");
        System.out.println(str1);
    }

    /**
     * @param n 数量
     * @param from 柱子1
     * @param in 柱子2
     * @param to 柱子3
     */
    public static void hanoi(int n,char from,char in,char to){
//        if(n==1){
//            System.out.println("第1个盘子从"+from+"移到"+to);
//        }else{
//            hanoi(n-1,from,to,in);
//            System.out.println("第"+n+"个盘子从"+from+"移到"+to);
//            hanoi(n-1,in,from,to);
//        }

    }
}
