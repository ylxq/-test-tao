package com.example.design.build.createor;

public class Hair {
    public Hair(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hair{" +
                "name='" + name + '\'' +
                '}';
    }
}
