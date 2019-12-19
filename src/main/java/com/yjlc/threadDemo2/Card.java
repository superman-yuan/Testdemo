package com.yjlc.threadDemo2;

import javax.cache.CacheManager;

/**
 * Created by Liuziyuan on 2019/9/13.
 */
public class Card implements Runnable {
    private String name;
    private Acount acount = new Acount();

    public Card(String name,Acount acount){
        this.acount=acount;
        this.name=name;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            acount.addAcount(name,100);
        }

    }
}
