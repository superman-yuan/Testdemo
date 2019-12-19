package com.yjlc.aspect;

import com.yjlc.annotation.AnalysisActuator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Liuziyuan on 2019/8/31.
 */
@Aspect
@Component
public class AnalysisActuatorAspect {
        final static Logger log = LoggerFactory.getLogger(AnalysisActuatorAspect.class);

        ThreadLocal<Long> beginTime = new ThreadLocal<>();

        @Pointcut("@annotation(analysisActuator)")
        public void serviceStatistics(AnalysisActuator analysisActuator) {

        }

        @Before("serviceStatistics(analysisActuator)")
        public void doBefore(JoinPoint joinPoint, AnalysisActuator analysisActuator) {
            // 记录请求到达时间
            beginTime.set(System.currentTimeMillis());
            log.info("cy666 note:{}", analysisActuator.value());
        }

        @After("serviceStatistics(analysisActuator)")
        public void doAfter(AnalysisActuator analysisActuator) {
            log.info("cy666 statistic time:{}, note:{}", System.currentTimeMillis() - beginTime.get(), analysisActuator.value());
        }
}
