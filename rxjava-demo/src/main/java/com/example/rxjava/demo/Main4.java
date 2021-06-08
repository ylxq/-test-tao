package com.example.rxjava.demo;

import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.Optional;

public class Main4 {
    public static void main(String[] args) {
        Flux.just(-1, 30, 13, 9, 20)
                .handle((i, sink) -> {
                    String letter = alphabet(i);
                    if (letter != null)
                        sink.next(letter);
                }).subscribe(System.out::println);

        Flux.just(-1, 30, 13, 9, 20)
                .map(i -> Optional.ofNullable(alphabet(i)))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .subscribe(System.out::println);

    }

    public static String alphabet(int letterNumber) {
        if (letterNumber < 1 || letterNumber > 26) {
            return null;
        }
        int letterIndexAscii = 'A' + letterNumber - 1;
        return "" + (char) letterIndexAscii;
    }
}
