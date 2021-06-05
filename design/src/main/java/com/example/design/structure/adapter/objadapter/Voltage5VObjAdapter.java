package com.example.design.structure.adapter.objadapter;

import com.example.design.structure.adapter.Voltage220;
import com.example.design.structure.adapter.Voltage5V;

public class Voltage5VObjAdapter implements Voltage5V {

    private Voltage220 voltage220;

    public Voltage5VObjAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public void show() {
        System.out.println("输出" + voltage220.getSrc() / 44 + "v");
    }
}
