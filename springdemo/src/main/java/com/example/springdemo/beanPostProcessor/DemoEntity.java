package com.example.springdemo.beanPostProcessor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DemoEntity {

    public DemoEntity(@Value("${a}") String val) {
        value = val;
    }

    private String value = "abc";

    public void print() {
        System.out.println(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
