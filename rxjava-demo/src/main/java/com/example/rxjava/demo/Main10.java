package com.example.rxjava.demo;

import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

public class Main10 {
    public static void main(String[] args) {
        Flux<String> flux = Flux
                .<String>error(new IllegalArgumentException())
                .doOnError(System.out::println)
                .retryWhen(Retry.from(companion ->
                        companion.take(3)))
                //.retry(3)
                ;

        flux.subscribe(System.out::println);


    }
}
