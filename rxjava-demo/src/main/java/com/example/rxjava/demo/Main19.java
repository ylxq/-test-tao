package com.example.rxjava.demo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Main19 {
    public static void main(String[] args) throws InterruptedException {

//        Schedulers.onHandleError((thread, throwable) -> {
//            System.out.println("error:"+thread.getName()+"==="+throwable+"===");
//        });

        Flux.just(1, 2, 3, 4, 5, 6, 0, 9)
                .map(val -> 100 / val)
                //.onErrorReturn(-1)
                .parallel(1)
                .runOn(Schedulers.parallel())
                .subscribe(i -> {
                    System.out.println(Thread.currentThread().getName() + " -> " +i);
                });


    }
}
