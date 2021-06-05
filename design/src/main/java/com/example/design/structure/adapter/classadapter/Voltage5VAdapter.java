package com.example.design.structure.adapter.classadapter;

import com.example.design.structure.adapter.Voltage220;
import com.example.design.structure.adapter.Voltage5V;

public class Voltage5VAdapter extends Voltage220 implements Voltage5V {
    @Override
    public void show() {
        System.out.println("输出" + super.getSrc() / 44 + "v");
    }
}
