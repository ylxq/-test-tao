package com.example.design.behavior.command;

public class CommandMain {

    public static void main(String[] args) {
        Tv tv = new XiaomiTv();

        TvCloseCommand tvCloseCommand = new TvCloseCommand(tv);
        TvOpenCommand tvOpenCommand = new TvOpenCommand(tv);

//        CommandInvoker commandInvoker = new CommandInvoker(tvCloseCommand);
//        CommandInvoker commandInvoker2 = new CommandInvoker(tvOpenCommand);
//        commandInvoker.call();
//        commandInvoker2.call();

        ComposeCommand commands = new ComposeCommand();
        commands.addCommand(tvCloseCommand);
        commands.addCommand(tvOpenCommand);

        CommandInvoker commandInvoker2 = new CommandInvoker(commands);
        commandInvoker2.call();
    }
}
