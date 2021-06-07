package com.example.design.structure.bridge;

public class TaiShiComputer extends Computer {

    public TaiShiComputer(Brand brand) {
        super(brand);
    }

    @Override
    void show() {
        System.out.println("台式机");
        brand.show();
    }
}
