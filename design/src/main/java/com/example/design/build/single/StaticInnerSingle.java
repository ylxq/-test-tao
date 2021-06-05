package com.example.design.build.single;

public class StaticInnerSingle {
    private StaticInnerSingle() {
    }
    private  static class SingletonHolder {
       private static StaticInnerSingle single = new StaticInnerSingle();
    }

    public static StaticInnerSingle getInstance() {
        return SingletonHolder.single;
    }

    public void don(){
        System.out.println("==================");
    }

    public static void main(String[] args) {
        StaticInnerSingle.getInstance().don();
    }
}
