package com.yjlc.service.impl;

import com.yjlc.service.StackService;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.ArrayStack;
import org.springframework.stereotype.Service;

/**
 * Created by Liuziyuan on 2019/9/3.
 */
@Slf4j
@Service
public class StackServiceImpl<T> implements StackService<T> {

    Object[] data;//对象数组

    int maxSize=3;//最大容量

    int top=0;//开始下标；

    private StackServiceImpl(){
        this.data=new Object[this.maxSize];
    }
    @Override
    public boolean isNotNull() {
        if(top==maxSize){
            log.info("-------------->>队列已满");
            return true;
        }
        return false;
    }

    @Override
    public Integer size() {
        return null;
    }


    @Override
    public boolean push(Object o) {
        if(!isNotNull()){
            data[top]=o;
            top++;
            return true;
        }
        return false;
    }

    @Override
    public T pop() {
        if(maxSize==0){
            return null;
        }
        T t = (T) this.data[top-1];//获取数组减一的值
//        this.data[top]=null;
        this.top--;
        return t;
    }

    @Override
    public T getMin() {
        int count =0;
        for (int i=1;i<data.length;i++){
            if(Integer.parseInt(data[count].toString())<Integer.parseInt(data[i].toString())){
                return (T) data[count];
            }
            count++;
        }
        return null;
    }

    public static void main(String[] args){
        StackService stackService = new StackServiceImpl<>();
        stackService.push("1234");
        stackService.push("4567");
        stackService.push("7890");
        System.out.println(stackService.isNotNull());
        System.out.println(stackService.getMin());
        System.out.println(stackService.pop());
        System.out.println(stackService.pop());
        System.out.println(stackService.pop());
        System.out.println(stackService.size());
    }
}
