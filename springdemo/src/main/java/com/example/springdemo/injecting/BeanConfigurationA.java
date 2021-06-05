package com.example.springdemo.injecting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationA {

    @Bean(initMethod = "init")
    public BeanOne beanOne1() {
        BeanOne beanOne = new BeanOne();
        System.out.println(beanOne+"A");
        return beanOne;
    }
}
