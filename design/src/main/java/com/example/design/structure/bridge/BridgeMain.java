package com.example.design.structure.bridge;

/**
 * 多维度组合
 */
public class BridgeMain {
    public static void main(String[] args) {
        HUAWEIBrand huaweiBrand = new HUAWEIBrand();
        XiAOMIBrand xiAOMIBrand = new XiAOMIBrand();


        new TaiShiComputer(xiAOMIBrand).show();
        new BiJiBenComputer(huaweiBrand).show();
        new BiJiBenComputer(xiAOMIBrand).show();
        new TaiShiComputer(huaweiBrand).show();
    }
}
