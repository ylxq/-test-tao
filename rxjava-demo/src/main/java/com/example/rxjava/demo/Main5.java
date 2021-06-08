package com.example.rxjava.demo;

import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main5 {
    public static void main(String[] args) throws InterruptedException {
        final Mono<String> mono = Mono.just("hello ");
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mono.map(msg -> msg + "thread ")
                    .subscribe(v ->
                            System.out.println(v + Thread.currentThread().getName())
                    );
            System.out.println("finshed");
        });

    }
}
