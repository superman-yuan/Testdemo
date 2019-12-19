package com.yjlc.threadDemo2;

/**
 * Created by Liuziyuan on 2019/9/13.
 */
public class Acount {

    private double count = 0;

    /**
     * 取钱
     * @param name
     * @param money
     */
    public void addAcount(String name,double money){
        count +=money;
        System.out.println("姓名："+name+"...存入.."+money+"...线程..."+Thread.currentThread().getName());
        selectAcount(name);
    }

    /**
     * 取钱
     * @param name
     * @param money
     */
    public void subAcount(String name,double money){
        if(count-money<0){
            System.out.println("余额不足！");
        }
        count-=money;
        System.out.println("取钱成功----》"+money);
        selectAcount(name);
    }

    public double selectAcount(String name){
         System.out.println(name+"...余额："+count);
         return count;
    }

}
