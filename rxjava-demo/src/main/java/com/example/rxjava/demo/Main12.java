package com.example.rxjava.demo;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.function.Function;

public class Main12 {
    public static void main(String[] args) {
        Function<Flux<String>, Flux<String>> filterAndMap =
                f -> f.filter(color -> !color.equals("orange"))
                        .map(String::toUpperCase);

        Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
                .doOnNext(System.out::println)
                .transform(filterAndMap)
                .subscribe(d -> System.out.println("Subscriber to Transformed MapAndFilter: "+d));
    }
}
