package com.example.design.structure.decoration;

public class Version50902Decorator extends Decorator{
    public Version50902Decorator(Compoment compoment) {
        super(compoment);
    }

    @Override
    public void operation(String version) {
        super.operation(version);

        System.out.println("5..9.2");
    }
}
