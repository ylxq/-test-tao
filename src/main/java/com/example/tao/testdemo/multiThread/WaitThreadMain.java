package com.example.tao.testdemo.multiThread;

import java.util.concurrent.TimeUnit;

public class WaitThreadMain  {
    /**
     * 暂停当前正在执行的线程对象，并执行其他线程。  *  * @param args  * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("wait");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wait.......");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock){
                    notify();
                }

                System.out.println("notify.......");
            }
        });


        t1.start();
        t2.start();
    }



}
