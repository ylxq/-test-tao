package com.example.rxjava.demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Main11 {
    public static void main(String[] args) {
        Sinks.Many<Integer> replaySink = Sinks.many().replay().all();

        //thread1
        replaySink.emitNext(1111, Sinks.EmitFailureHandler.FAIL_FAST);

//thread2, later
        replaySink.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST);

//thread3, concurrently with thread 2
        replaySink.tryEmitNext(4); //would return FAIL_NON_SERIALIZED

        Flux<Integer> fluxView =replaySink.asFlux();
        fluxView
                .subscribe(System.out::println);
    }
}
