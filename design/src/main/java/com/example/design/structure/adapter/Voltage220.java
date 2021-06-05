package com.example.design.structure.adapter;

public class Voltage220 {
    private int src = 220;

    public void show() {
        System.out.println("输出" + src + "电压");
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }
}
