package com.example.springreddisson;

import com.example.springreddisson.test.RedissonTest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringReddissonApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringReddissonApplication.class, args);
    }

    @Resource
    RedissonTest redissonTest;
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 9999; i++) {
            new Thread(()-> redissonTest.redissonTest("test111")).start();
        }

    }
}
