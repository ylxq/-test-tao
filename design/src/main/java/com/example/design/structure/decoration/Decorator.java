package com.example.design.structure.decoration;

public abstract class Decorator implements Compoment {
    Compoment compoment;

    public Decorator(Compoment compoment) {
        this.compoment = compoment;
    }

    @Override
    public void operation(String version) {
        if (compoment != null) {
            compoment.operation(version);
        }
    }
}
