package com.example.design.behavior.command;

public class TvOpenCommand implements Command {

    private Tv tv;

    public TvOpenCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        if (tv != null) {
            tv.open();
        }
    }
}
