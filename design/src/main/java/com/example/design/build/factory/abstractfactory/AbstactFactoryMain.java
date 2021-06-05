package com.example.design.build.factory.abstractfactory;

import com.example.design.build.factory.abstractfactory.huawei.HuaweiFactory;

public class AbstactFactoryMain {
    public static void main(String[] args) {
        Factory factory = new HuaweiFactory();
        System.out.println(factory.createBook().name);
        System.out.println(factory.createPhone().name);
        System.out.println(factory.createWatch().name);
    }
}
