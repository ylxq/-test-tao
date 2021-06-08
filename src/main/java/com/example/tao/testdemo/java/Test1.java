package com.example.tao.testdemo.java;

import org.springframework.util.StopWatch;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        StopWatch stopWatch= new StopWatch("task");
        stopWatch.start("test");
        List<People> workers = new LinkedList<>();
        workers.add(new People("aa", 23));
        workers.add(new People("abc", 21));
        workers.add(new People("cdf", 18));
        workers.stream().sorted(Comparator.comparingInt(People::getAge).reversed()).forEach(System.out::println);
        stopWatch.stop();

        String s = stopWatch.prettyPrint();
        System.out.println(s);
    }
}

class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

