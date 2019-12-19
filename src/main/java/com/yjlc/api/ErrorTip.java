package com.yjlc.api;

/**
 * 接口请求失败返回数据格式定义
 *
 * @author JackYuan
 * @create 2017-08-17 15:48
 */
public class ErrorTip<T> extends Tip<T> {
    /**
     * 为了保证功能独立性，故不应用系统的其他变量，但是保持值一致
     */
    public static final int CODE = 3000;
    /**
     * 操作失败的默认消息提示
     */
    public static final String MESSAGE = "业务异常";

    public ErrorTip(String message) {
        this(null, message);
    }

    public ErrorTip(int code, String message) {
        this(code, null, message);
    }

    public ErrorTip(T data, String message) {
        this(CODE, data, message);
    }

    public ErrorTip(int code, T data, String message) {
        super();
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
