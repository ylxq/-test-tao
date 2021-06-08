package com.example.rxjava.demo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Main6 {
    public static void main(String[] args) {
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);

        final Flux<String> flux = Flux
                .range(1, 2)
                .log("abc")
                .map(i -> 10 + i)
                .log("abc1111")
                .publishOn(s)
                //.subscribeOn(s)
                .map(i -> "value " + i)
                .log("abc2222");

        new Thread(() -> flux.subscribe(val->{
            System.out.println(val+Thread.currentThread().getName());
        })).start();
    }
}
