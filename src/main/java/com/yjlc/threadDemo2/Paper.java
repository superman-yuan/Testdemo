package com.yjlc.threadDemo2;

/**
 * Created by Liuziyuan on 2019/9/13.
 */
public class Paper implements Runnable{

    private String name;
    private Acount acount = new Acount();

    public Paper(String name,Acount acount){
        this.name=name;
        this.acount=acount;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            acount.subAcount(name,50);
        }
    }
}
