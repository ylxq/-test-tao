package com.example.rxjava.demo;

import reactor.core.publisher.Flux;

public class Main7 {
    public static void main(String[] args) {
        Flux.just(1, 2, 0, 5, 7, 9)
                .map(i -> "100 / " + i + " = " + (100 / i)) //this triggers an error with 0
//                .onErrorReturn("Divided by zero :(")
//                .onErrorContinue((error, val) -> {
//                    System.out.println(val + error.toString());
//                })
                // .onErrorMap(val -> new NullPointerException("Error val:" + val))
                // .onErrorResume((throwable) -> Flux.just(throwable.getMessage()))
                .doOnError(error -> {
                    System.out.println("error:" + error);
                })
                .onErrorReturn("test/0000")
                .subscribe(System.out::println);
    }
}
