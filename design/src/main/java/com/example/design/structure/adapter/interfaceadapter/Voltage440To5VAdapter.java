package com.example.design.structure.adapter.interfaceadapter;

import com.example.design.structure.adapter.Voltag440V;

public class Voltage440To5VAdapter implements HandlerAdapter {

    @Override
    public boolean support(Object handler) {
        return handler instanceof Voltag440V;
    }

    @Override
    public void handler(Object handler) {
        ((Voltag440V) handler).show();
    }
}
