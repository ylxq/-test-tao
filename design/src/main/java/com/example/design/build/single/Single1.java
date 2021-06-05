package com.example.design.build.single;

public class Single1 {
    private final static Single1 INSTANCE = new Single1();

    public static Single1 getInstance() {
        return INSTANCE;
    }
}
