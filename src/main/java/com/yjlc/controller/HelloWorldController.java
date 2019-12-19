package com.yjlc.controller;

import com.yjlc.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Liuziyuan on 2019/8/31.
 */
@RestController
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        return helloWorldService.getHelloMessage(name);
    }
}
