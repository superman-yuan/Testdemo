package com.yjlc.utill;

import com.yjlc.annotation.AnalysisActuator;
import com.yjlc.annotation.Lock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liuziyuan on 2019/9/7.
 */
@Slf4j
@Aspect
@Component
public class DistributedRedisLockUtil {

    private static Redisson redisson = RedissonManager.getRedisson();

    private static final String LOCk_TITLE="redisLock_";

    @Pointcut("@annotation(lock)")
    public void serviceStatistics(Lock lock) {

    }

    @Before("serviceStatistics(lock)")
    public static boolean acquire(Lock lock){
        try {
            String key = LOCk_TITLE + lock.LockName();

            RLock mylock = redisson.getLock(lock.LockName());

            mylock.lock(2, TimeUnit.MINUTES);

            log.info("lockName{}", Thread.currentThread().getName());
        }catch(Exception e){

        }
        return true;
    }

    @After("serviceStatistics(lock)")
    public static void release(Lock lock){
        String key = LOCk_TITLE+lock.LockName();
        RLock rLock = redisson.getLock(key);
        rLock.unlock();
        log.info("======unlock======"+Thread.currentThread().getName());
    }



        public static int fn(int n) {
            if (n == 0) {
                return 0;
            } else if (n == 1 | n == 2) {
                return 1;
             } else return fn(n - 1) + fn(n - 2);
        }

        public static void main(String[] args) {
            int N, M, sum;
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                N = Integer.parseInt(sc.next());
//                M = Integer.parseInt(sc.next());
                sum = fn(N);
                System.out.println(sum);
            }
        }

}
