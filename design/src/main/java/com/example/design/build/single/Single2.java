package com.example.design.build.single;

public enum Single2 {

    INSTANCE;

    public void doSomething() {
        System.out.println("11111111111");
    }


    public static void main(String[] args) {
        Single2.INSTANCE.doSomething();
    }

}
