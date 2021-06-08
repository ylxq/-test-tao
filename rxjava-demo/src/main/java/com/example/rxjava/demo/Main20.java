package com.example.rxjava.demo;

import reactor.core.publisher.Mono;

public class Main20 {
    public static void main(String[] args) {
        String key = "message";
        Mono<String> r = Mono.just("Hello")
                .flatMap(
                        s -> Mono.deferContextual(ctx -> Mono.just(s + " " + ctx.get(key) + " " + ctx.get("abc")))
                )
                .contextWrite(ctx -> ctx.put(key, "World"))
                .contextWrite(ctx -> ctx.put(key, "World111"))
                .contextWrite(ctx -> ctx.put("abc", "agc"));
        r.subscribe(System.out::println);
    }
}
