package com.example.rxjava.demo;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class Main1 {

    public static void main(String[] args) throws InterruptedException {
//        Flux.just("hello","world")
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onSubscribe(Subscription subscription) {
//                        subscription.request(Long.MAX_VALUE);
//                        System.out.println("1");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        System.out.println(s);
//                        System.out.println("2");
//                        throw new NullPointerException();
//                    }
//
//                    @Override
//                    public void onError(Throwable throwable) {
//                        System.out.println("3");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.out.println("4");
//                    }
//                });
//        Flux.just("hello","world")
//                .subscribe(value->{
//                    System.out.println("1");
//                    System.out.println(value);
//                    throw new NullPointerException();
//                },(error)->{
//                    System.out.println("2");
//                    error.printStackTrace();
//                },()-> System.out.println("complete"));

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Disposable disposable = Flux.interval(Duration.ofSeconds(1))
                .log()
                .filter(value -> LocalDateTime.now().getSecond() % 3 == 0)
                .doOnCancel(countDownLatch::countDown)
                .buffer(10)
                .subscribe(System.out::println
                        , error -> {
                        }
                        , () -> System.out.println("finshed"));


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(50);
                disposable.dispose();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        System.out.println("wait............");
      //  countDownLatch.await();
    }
}
