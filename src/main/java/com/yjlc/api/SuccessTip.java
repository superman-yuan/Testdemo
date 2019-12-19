package com.yjlc.api;

/**
 * 接口请求成功返回数据格式定义
 *
 * @author JackYuan
 * @create 2017-08-17 15:34
 */
public class SuccessTip<T> extends Tip<T> {
    /**
     * 为了保证功能独立性，故不应用系统的其他变量，但是保持值一致
     */
    public static final int CODE = 1000;
    /**
     * 操作成功的消息提示
     */
    public static final String MESSAGE = "操作成功";

    public SuccessTip() {
        this(null);
    }

    public SuccessTip(T data) {
        this(data, MESSAGE);
    }

    public SuccessTip(T data, String message) {
        this.code = CODE;
        this.message = message;
        this.data = data;
    }
}
