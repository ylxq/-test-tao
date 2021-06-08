package com.example.springdemo.test;

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author GLNC-taowenchen
 */
public class ApplicationContextDemo {

    /**
     * 加载 多资源的配置  xml 和 groovy 配置
     *
     * @param args
     */
    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(applicationContext).loadBeanDefinitions("/xml/application.xml");
        new GroovyBeanDefinitionReader(applicationContext).loadBeanDefinitions("/groovy/application.groovy");

        /*
        只能refresh 一次
         */
        applicationContext.refresh();


        DemoService demoService1 = applicationContext.getBean("demoService1", DemoService.class);
        demoService1.print("demoservice1");

        DemoService demoService2 = applicationContext.getBean("demoService2", DemoService.class);
        demoService2.print("demoservice2");
    }
}
