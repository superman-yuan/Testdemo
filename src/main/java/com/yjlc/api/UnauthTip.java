package com.yjlc.api;

/**
 * 接口请求无权限返回数据格式定义
 *
 * @author JackYuan
 * @create 2017-08-17 15:56
 */
public class UnauthTip extends Tip<Object> {

    public static final int CODE = 1002;
    public static final String MESSAGE = "您没有权限访问该功能！请联系管理员为您配置权限！";

    public UnauthTip() {
        this(null);
    }

    public UnauthTip(Object data) {
        this.code = CODE;
        this.message = MESSAGE;
        this.data = data;
    }
}
