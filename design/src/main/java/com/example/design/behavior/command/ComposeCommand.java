package com.example.design.behavior.command;

import java.util.ArrayList;
import java.util.List;

public class ComposeCommand implements Command {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void removeCommand(Command command) {
        commandList.remove(command);
    }


    @Override
    public void execute() {
        commandList.forEach(Command::execute);
    }
}
