package com.example.design.build.factory.simple;

/**
 * @author taowenchen
 */
public class CircleButton extends AbstractButton {

    public CircleButton(String name) {
        this.name = name;
    }

    @Override
    public void click() {
        System.out.println("i am circle");
    }
}
