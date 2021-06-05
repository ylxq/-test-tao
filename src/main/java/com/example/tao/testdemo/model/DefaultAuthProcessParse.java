package com.example.tao.testdemo.model;

public class DefaultAuthProcessParse implements AuthProcessParse {
    @Override
    public ProcessContext execute(ProcessContext processContext) {
        return null;
    }

    @Override
    public int order() {
        return 10;
    }

    @Override
    public boolean needRun(ProcessContext processContext) {
        return true;
    }
}
