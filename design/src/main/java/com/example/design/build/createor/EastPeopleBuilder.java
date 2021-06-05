package com.example.design.build.createor;

public class EastPeopleBuilder implements Builer {

    People people = new People();

    @Override
    public void buildHair() {
        people.setHair(new Hair("黑发"));
    }

    @Override
    public void buildEye() {
        people.setEye(new Eye("棕眼"));
    }

    @Override
    public void buildMouse() {
        people.setMouse(new Mouse("殷桃小嘴"));
    }

    @Override
    public People getResult() {
        return people;
    }
}
