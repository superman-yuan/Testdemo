package com.yjlc.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Liuziyuan on 2019/9/13.
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        /**
         * 核心线程
         */
        executor.setCorePoolSize(50);
        /**
         * 最大线程数
         */
        executor.setMaxPoolSize(200);
        /**
         * 队列长度
         */
        executor.setQueueCapacity(2000);
        /**
         * 线程超时，时间
         */
        executor.setKeepAliveSeconds(60);
        /**
         * 线程名称前缀
         */
        executor.setThreadNamePrefix("TaskExecutor");
        /**
         * 任务丢弃策略，饱和。
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        /**
         * 初始化
         */
        executor.initialize();

        return executor;
    }

}
