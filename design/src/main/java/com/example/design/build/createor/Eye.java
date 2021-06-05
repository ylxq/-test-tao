package com.example.design.build.createor;

public class Eye {
    public Eye(String name) {
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
        return "Eye{" +
                "name='" + name + '\'' +
                '}';
    }
}
