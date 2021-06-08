package com.example.rxjava.demo;

import reactor.core.publisher.Flux;

public class Main3 {

    public static void main(String[] args) {
        Flux.create((sink)->{
            sink.next("1");
        }).subscribe(System.out::println);

    }
}
