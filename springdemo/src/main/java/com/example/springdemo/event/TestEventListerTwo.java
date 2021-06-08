package com.example.springdemo.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestEventListerTwo {


    @EventListener
    public void listern2(TestEvent event) {
        System.out.println(event.getContent() + "22222222222");
    }
}
