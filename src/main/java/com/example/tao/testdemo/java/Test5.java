package com.example.tao.testdemo.java;

import java.util.Optional;

public class Test5 {

    static Optional<Integer> getOptionInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        getOptionInt("1");
        getOptionInt("sss");

    }

}
