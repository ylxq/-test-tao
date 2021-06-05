package com.example.springdemo.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author GLNC-taowenchen
 */
@Service
@EnableRabbit
public class RabbitService {

    private static final String QUEUE = "0500-test444444";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(String value) {
        rabbitTemplate.convertAndSend(QUEUE, value);
    }


//    @RabbitListener(queues = QUEUE)
//    public void get(String value) {
//        System.out.println(value+"收到");
//    }


}
