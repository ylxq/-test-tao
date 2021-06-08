package com.example.springdemo.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {


//    @Bean
//    public String test(@Value("${a}") String val) {
//        System.out.println("===========" + val);
//        return val;
//    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory);
    }

}
