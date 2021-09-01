package com.example.design.structure.decoration;

public class DecorationMain {
    public static void main(String[] args) {
        Compoment compoment = new CompomentA();

        compoment = new DecoratorA(compoment);
        compoment = new DecoratorB(compoment);
        compoment = new Version50902Decorator(compoment);
        compoment = new Version50903Decorator(compoment);

        String version = "5.9.2";
//        compoment.operation(version);
        compoment.operation(version);
    }
}
