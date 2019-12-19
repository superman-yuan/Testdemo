package com.yjlc.api;

import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

/**
 * Created by mac on 2017/8/17.
 */
public class HttpKit {

    public static <T> SuccessTip<T> success() {
        return success(null);
    }

    public static <T> SuccessTip<T> success(T data) {
        return success(data, "操作成功");
    }

    public static <T> SuccessTip<T> success(T data, String message) {
        return new SuccessTip<T>(data, message);
    }

    public static <T> Tip<T> failed(String message) {
        return failed(null, message);
    }

    public static <T> ErrorTip<T> failed(T data, String message) {
        return new ErrorTip<T>(data, message);
    }

    public static Tip<Object> unauthorized() {
        return new ErrorTip<Object>(FORBIDDEN.value(),FORBIDDEN.getReasonPhrase());
    }

    public static Tip<Object> unlogin() {
        return new ErrorTip<Object>(UNAUTHORIZED.value(),UNAUTHORIZED.getReasonPhrase());
    }

    /**
     * 根据map结构的返回值来解析操作结果，只包含操作状态和操作消息
     *
     * map的可以应为success：标记是否成功，message：标记消息
     *
     * @param map
     * @return
     */
    public static Tip<Object> from(Map<String, Object> map) {
        boolean success = (Boolean) map.get("success");
        String message = (String) map.get("message");
        if (success) {
            return success(null, message);
        } else {
            return failed(message);
        }
    }
}
