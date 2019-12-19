package com.yjlc.api;

/**
 * 接口返回提示（最终转化为json形式）
 * @author JackYuan
 * @create 2017-08-17 15:26
 */
public class Tip<T> {

    private static final int DEFAULT_CODE = 1000;

    /** 接口状态码 */
    protected String message;
    /** 接口文本消息 */
    protected  T data;
    /** 接口数据 */
    protected int code = DEFAULT_CODE;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
