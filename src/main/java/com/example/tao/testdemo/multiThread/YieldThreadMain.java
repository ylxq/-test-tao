package com.example.tao.testdemo.multiThread;

public class YieldThreadMain implements Runnable {
    private String name;

    public YieldThreadMain(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name + ":" + i + "......yield.............");
            Thread.yield();
        }
    }

    /**
     * 暂停当前正在执行的线程对象，并执行其他线程。  *  * @param args  * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new YieldThreadMain("t1"));
        Thread t2 = new Thread(new YieldThreadMain("t2"));
        t1.start();
        t2.start();
    }

}
