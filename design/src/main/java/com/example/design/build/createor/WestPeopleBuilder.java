package com.example.design.build.createor;

public class WestPeopleBuilder implements Builer {
    People people = new People();

    @Override
    public void buildHair() {
        people.setHair(new Hair("金发"));
    }

    @Override
    public void buildEye() {
        people.setEye(new Eye("碧眼"));
    }

    @Override
    public void buildMouse() {
        people.setMouse(new Mouse("大红唇"));
    }

    @Override
    public People getResult() {
        return people;
    }
}
