package com.example.rxjava.demo;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

public class Main9 {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Mono.using(() -> new FileInputStream("D:/test.txt"),
                fileInputStream -> {
                    try {
                        ByteBuffer bytes = ByteBuffer.allocate(1024);
                        fileInputStream.getChannel().read(bytes);
                        return Mono.just(new String(bytes.array()));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return Mono.empty();
                    }
                }
                , fileInputStream -> {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                .publishOn(Schedulers.boundedElastic())
                .onErrorReturn("no file")
                .doFinally((type -> countDownLatch.countDown()))
                .subscribe(System.out::println);

        countDownLatch.await();
    }
}
