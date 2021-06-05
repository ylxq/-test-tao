package com.example.design.build.factory.factorymethod.product;

public class FileLog implements Log{
    @Override
    public void info() {
        System.out.println("file log");
    }
}
