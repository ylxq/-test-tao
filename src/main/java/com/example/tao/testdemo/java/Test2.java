package com.example.tao.testdemo.java;

public class Test2 {
    @FunctionalInterface
    public interface LambdaDemo {
        void run();
    }

    public String abc = "123";

    public static void doSomeThing(LambdaDemo demo) {
        demo.run();
    }

    public void doN(String[] args) {
        doSomeThing(() ->
        {
            System.out.println("sdfd");
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(Thread.currentThread().getName());
        String acc = "123";
        doSomeThing(new LambdaDemo() {
            @Override
            public void run() {
                System.out.println(abc);
                System.out.println(Thread.currentThread().getName());
            }
        });
        doSomeThing(new Test3(abc));
        abc = "1231";
    }

    public static void main(String[] args) {
        new Test2().doN(args);
    }
}
