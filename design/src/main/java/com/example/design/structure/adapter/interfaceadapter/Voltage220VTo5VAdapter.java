package com.example.design.structure.adapter.interfaceadapter;

import com.example.design.structure.adapter.Voltage220;

public class Voltage220VTo5VAdapter implements HandlerAdapter {

    @Override
    public boolean support(Object handler) {
        return handler instanceof Voltage220;
    }

    @Override
    public void handler(Object handler) {
        ((Voltage220) handler).show();
    }
}
