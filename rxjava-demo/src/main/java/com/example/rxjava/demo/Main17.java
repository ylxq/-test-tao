package com.example.rxjava.demo;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class Main17 {
    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> source = Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("subscribed to source"));

        Flux<Integer> co = source.publish().refCount(2);

        co.subscribe(System.out::println, e -> {}, () -> {});
        co.subscribe(System.out::println, e -> {}, () -> {});

        System.out.println("done subscribing");
        Thread.sleep(500);
        System.out.println("will now connect");


    }
}
