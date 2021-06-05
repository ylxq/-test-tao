package com.example.design.build.factory.factorymethod;

import com.example.design.build.factory.factorymethod.factory.ConsoleLogFactory;
import com.example.design.build.factory.factorymethod.factory.LogFactory;

public class FactoryMain {
    public static void main(String[] args) {
        LogFactory factory = new ConsoleLogFactory();
        factory.createLog().info();
    }
}
