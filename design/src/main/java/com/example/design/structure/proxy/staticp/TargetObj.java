package com.example.design.structure.proxy.staticp;

public class TargetObj  implements TargetService {

    @Override
    public void operation() {
        System.out.println("干啥事");
    }
}