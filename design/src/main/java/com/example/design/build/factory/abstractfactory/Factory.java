package com.example.design.build.factory.abstractfactory;

public interface Factory {

    Phone createPhone();

    Book createBook();

    default Watch createWatch(){return null;};
}
