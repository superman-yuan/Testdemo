package com.yjlc.api;

/**
 * Created by Liuziyuan on 2019/9/7.
 */
public class ExceptionCustom extends Exception {
    //无参构造
    public ExceptionCustom(){
        super();
    }

    //用详细信息指定一个异常
    public ExceptionCustom(String message){
        super(message);
    }

    //用指定的详细信息和原因构造一个新的异常
    public ExceptionCustom(String message, Throwable cause){
        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public ExceptionCustom(Throwable cause) {
        super(cause);
    }
}
