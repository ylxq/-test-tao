package com.example.tao.testdemo.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessChainHandler implements ProcessChain {

    private List<ProcessParse> parseList = new ArrayList<>();

    {
        parseList.add(new DefaultAuthProcessParse());
        parseList.sort(Comparator.comparingInt(ProcessParse::order));
    }


    @Override
    public ProcessContext process(ProcessContext processContext) {
        for (ProcessParse processParse : parseList) {
            if (processParse.needRun(processContext)) {
                processContext = processParse.execute(processContext);
            }
        }
        return processContext;
    }
}
