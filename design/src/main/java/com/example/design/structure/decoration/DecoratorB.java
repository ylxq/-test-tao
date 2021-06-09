package com.example.design.structure.decoration;

public class DecoratorB extends Decorator{
    public DecoratorB(Compoment compoment) {
        super(compoment);
    }

    protected void after() {
        System.out.println("干完了事 还要干这个");
    }

    @Override
    public void operation() {
        super.operation();
        after();
    }
}
