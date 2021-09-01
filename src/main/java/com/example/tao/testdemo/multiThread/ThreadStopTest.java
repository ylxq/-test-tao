package com.example.tao.testdemo.multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadStopTest {

    public static void main(String[] args) throws InterruptedException {

//        Lock lock = new ReentrantLock(false);
//
        final Thread aaa = new Thread(){
            @Override
            public synchronized void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("aaa");
                }
            }
        };
        aaa.start();
        Thread.sleep(10000);
        aaa.stop();
//        aaa.stop(new RuntimeException());

    }
}
