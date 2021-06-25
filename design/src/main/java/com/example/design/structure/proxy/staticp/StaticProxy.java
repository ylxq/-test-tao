package com.example.design.structure.proxy.staticp;

public class StaticProxy implements TargetService {

    private final TargetService targetObj;

    public StaticProxy() {
        this.targetObj = new TargetObj();
    }

    @Override
    public void operation() {
        before();
        targetObj.operation();
    }

    private void before() {
        System.out.println("我是代理 我来干");
    }

    public static void main(String[] args) {
        new StaticProxy().operation();
    }
}
