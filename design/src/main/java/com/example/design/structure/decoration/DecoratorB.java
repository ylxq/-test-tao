package com.example.design.structure.decoration;

import java.lang.reflect.Method;

public class DecoratorB extends Decorator {
    public DecoratorB(Compoment compoment) {
        super(compoment);
    }

    protected void after() {
        System.out.println("干完了事 还要干这个");
    }

    @Override
    public void operation(String version) {
        super.operation(version);
        try {
            Method method = this.getClass().getMethod("action" + version.replace(".", "0"), String.class);
            method.invoke(this, version);
        } catch (Exception e) {
//            e.printStackTrace();
            //donothing
        }
    }

    public void action50902(String abc) {
        System.out.println(abc);
    }

    public void action50903(String abc) {
        System.out.println(abc);
    }
}
