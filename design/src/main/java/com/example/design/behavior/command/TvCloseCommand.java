package com.example.design.behavior.command;

public class TvCloseCommand implements Command {

   private Tv tv;

    public TvCloseCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        if (tv != null) {
            tv.close();
        }
    }
}
