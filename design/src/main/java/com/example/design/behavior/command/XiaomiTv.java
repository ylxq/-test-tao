package com.example.design.behavior.command;

public class XiaomiTv implements Tv {


    @Override
    public void open() {
        System.out.println("开启电视");
    }

    @Override
    public void close() {
        System.out.println("关闭电视");
    }
}
