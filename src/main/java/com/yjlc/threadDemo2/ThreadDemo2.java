package com.yjlc.threadDemo2;

/**
 * Created by Liuziyuan on 2019/9/13.
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Acount acount = new Acount();

        Card card= new Card("liuziyuan",acount);

        Paper paper = new Paper("liuziyuan",acount);

        Thread threadC = new Thread(card);
        Thread threadP = new Thread(paper);

        threadC.start();
        threadP.start();
    }
}
