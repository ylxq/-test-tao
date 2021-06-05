package com.example.tao.testdemo.model;

public interface ProcessParse {

    ProcessContext execute(ProcessContext processContext);

    int order();

    boolean needRun(ProcessContext processContext);

}
