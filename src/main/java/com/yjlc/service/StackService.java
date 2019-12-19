package com.yjlc.service;

/**
 * Created by Liuziyuan on 2019/9/3.
 */
public interface StackService<T> {
    //判断是否为空
    boolean isNotNull();
    //获取栈大小
    Integer size();
    //入栈
    boolean push(T t);
    //出栈
    T pop();
    //获取最小的值
    T getMin();
}
