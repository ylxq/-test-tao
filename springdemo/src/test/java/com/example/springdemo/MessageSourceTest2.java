package com.example.springdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class MessageSourceTest2 extends SpringdemoApplicationTests {

    @Autowired
    MessageSource messageSource;

    @Test
    void test2() {
        String a = messageSource.getMessage("a", new Object[]{"哈哈"}, Locale.getDefault());
        System.out.println(a);
    }
}
