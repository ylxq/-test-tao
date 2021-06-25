package com.example.design.behavior.command;

public class CommandInvoker {
    Command command;

    public CommandInvoker(Command command) {
        this.command = command;
    }

    void call() {
        if (command != null) {
            command.execute();
        }
    }
}
