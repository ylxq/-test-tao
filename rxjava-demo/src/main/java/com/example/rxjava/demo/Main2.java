package com.example.rxjava.demo;

import reactor.core.publisher.Flux;

public class Main2 {
    public static void main(String[] args) {
        Flux.generate(() -> "abc", (state, sink) -> {
            String temp = state + "1";
            sink.next(temp);
            if (temp.length() > 10) sink.complete();
            return temp;
        },s -> {
            System.out.println("s:"+s);
        }).subscribe(System.out::println);
    }

}
