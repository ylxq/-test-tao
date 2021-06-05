package com.example.design.structure.adapter.interfaceadapter;

public interface HandlerAdapter {

    boolean support(Object handler);

    void handler(Object handler);
}
