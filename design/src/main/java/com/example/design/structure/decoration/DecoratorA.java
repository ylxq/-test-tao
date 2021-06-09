package com.example.design.structure.decoration;

public class DecoratorA extends Decorator{
    public DecoratorA(Compoment compoment) {
        super(compoment);
    }

    protected void before() {
        System.out.println("给你干事之前把这个干了");
    }

    @Override
    public void operation() {
        before();
        super.operation();
    }
}
