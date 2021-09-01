package com.example.tao.testdemo.multiThread;

public class ThreadStopTest2 {

    public static void main(String[] args) throws InterruptedException {
        final Thread aaa = new Thread() {
            @Override
            public synchronized void run() {
                while (!isInterrupted()) {
//                    try {
//                        Thread.sleep(1000);
                        System.out.println("aaa");
//                    } catch (InterruptedException e) {
//                        System.out.println("中断了？？？？？？");
//                        flag = false;
//                    }


                }
            }
        };
        aaa.start();
        Thread.sleep(10000);
        aaa.interrupt();

        System.out.println(aaa.isInterrupted());
        System.out.println(aaa.isInterrupted());
//        aaa.stop(new RuntimeException());

    }
}
