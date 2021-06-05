package com.example.design.build.factory.factorymethod.product;

public class ConsoleLog implements Log{
    @Override
    public void info() {
        System.out.println("console log");
    }
}
