package com.example.design.build.factory.simple;

/**
 * @author taowenchen
 */
public class SimpleFactory {

    public static AbstractButton createButton(String name) {

        if ("circle".equals(name)) {
            return new CircleButton(name);
        } else {
            return new ReactButton();
        }
    }

    public static void main(String[] args) {
        SimpleFactory.createButton("123123").click();
    }
}
