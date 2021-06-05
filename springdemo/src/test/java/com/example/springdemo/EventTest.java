package com.example.springdemo;

import com.example.springdemo.event.TestEventPulisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class EventTest extends SpringdemoApplicationTests {

    @Autowired
    TestEventPulisher testEventPulisher;

    @Test
    void eventTest() throws InterruptedException {
        testEventPulisher.send("哈喽");
        TimeUnit.SECONDS.sleep(1000);
    }
}
