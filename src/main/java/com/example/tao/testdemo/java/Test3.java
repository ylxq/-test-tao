package com.example.tao.testdemo.java;

public class Test3 implements Test2.LambdaDemo {
    private String abc;

    public Test3(String abc) {
        this.abc = abc;
    }

    @Override
    public void run() {
        System.out.println(abc);
    }
}
