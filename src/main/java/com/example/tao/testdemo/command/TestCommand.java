package com.example.tao.testdemo.command;

public class TestCommand implements Command<String> {


    @Override
    public String execute() {
        return "hello";
    }

    public static void main(String[] args) {
        String execute = new TestCommand().execute();
        System.out.println(execute);
    }
}
