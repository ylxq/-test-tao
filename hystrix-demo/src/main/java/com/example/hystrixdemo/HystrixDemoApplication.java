package com.example.hystrixdemo;

import com.example.hystrixdemo.demo.HystrixObservableDemoCommand;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsPoller;
import org.reactivestreams.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@SpringBootApplication
@RestController
public class HystrixDemoApplication implements CommandLineRunner {
    private Queue queue = new ArrayBlockingQueue(1024);

    public static void main(String[] args) {
        SpringApplication.run(HystrixDemoApplication.class, args);
    }

    @RequestMapping(value = "/test.stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> sendTimePerSec() {
        return Flux.interval(Duration.ofSeconds(2)).
                map(l -> queue.poll() + "");
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }


    @Override
    public void run(String... args) throws Exception {
        HystrixMetricsPoller poller = new HystrixMetricsPoller(json -> {
            queue.add(json);
        }, 1000);
        HystrixObservableDemoCommand.test(poller);
    }
}
