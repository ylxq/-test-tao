package com.example.rxjava.demo;

import reactor.core.publisher.Flux;

public class Main18 {
    public static void main(String[] args) {
        Flux.just(1, 3, 5, 2, 4, 6, 11, 12, 13)
                .groupBy(i -> i % 2 == 0 ? "even" : "odd")

                .concatMap(g -> g.defaultIfEmpty(-1) //if empty groups, show them
                        .map(String::valueOf)//map to string
                        .startWith(g.key()))
        .subscribe(System.out::println);
    }
}
