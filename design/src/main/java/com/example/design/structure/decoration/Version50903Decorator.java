package com.example.design.structure.decoration;

public class Version50903Decorator extends Decorator{
    public Version50903Decorator(Compoment compoment) {
        super(compoment);
    }

    @Override
    public void operation(String version) {
        super.operation(version);

        System.out.println("5..9.3");
    }
}
