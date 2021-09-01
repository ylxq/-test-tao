package com.example.springreddisson.test;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.RedisSessionProperties;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedissonTest {

    @Autowired
    private RedissonClient redissonClient;

    private volatile static int total = 10;

    public String redissonTest(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            if (!lock.tryLock(100, 1000,TimeUnit.SECONDS)) {
                return "";
            }

            if (total < 1) {
                return "";
            }
            total--;
            System.out.println("--------------" + total);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
        return "已解锁";
    }

}
