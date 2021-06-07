package com.example.design.structure.bridge;

public class BiJiBenComputer extends Computer {

    public BiJiBenComputer(Brand brand) {
        super(brand);
    }

    @Override
    void show() {
        System.out.println("笔记本");
        brand.show();
    }
}
