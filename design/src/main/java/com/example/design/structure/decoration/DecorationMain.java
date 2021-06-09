package com.example.design.structure.decoration;

public class DecorationMain {
    public static void main(String[] args) {
        Compoment compoment = new CompomentA();

        compoment = new DecoratorA(compoment);
        compoment = new DecoratorB(compoment);

        compoment.operation();
    }
}
