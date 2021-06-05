package com.example.springdemo;

import com.example.springdemo.ltw.LtwBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// 添加下面这个注解就可以运行测试了
@SpringBootTest(classes = {com.example.springdemo.SpringdemoApplication.class})
class SpringdemoApplicationTests {

    @Autowired
    LtwBean ltwBean;

    @Test
    void contextLoads() {
        ltwBean.test();
    }

}
