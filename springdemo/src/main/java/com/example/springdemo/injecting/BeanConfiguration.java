package com.example.springdemo.injecting;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Configuration
@Import(BeanConfigurationA.class)
public class BeanConfiguration {

    @Bean(initMethod = "init")
    public BeanOne beanOne() {
        BeanOne beanOne = new BeanOne();
        System.out.println(beanOne);
        return beanOne;
    }

    @Bean(initMethod = "init")
    public BeanTwo beanTwo() {
        return new BeanTwo(beanOne());
    }
    @Bean(initMethod = "init")
    public BeanTwo beanTwo1() {
        return new BeanTwo(beanOne());
    }


}
