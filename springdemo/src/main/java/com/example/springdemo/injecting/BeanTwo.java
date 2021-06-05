package com.example.springdemo.injecting;

public class BeanTwo {

    public void init() {
        System.out.println("BeanTwo init");
    }

    public BeanTwo(BeanOne beanOne) {
        System.out.println(beanOne);
    }
}
