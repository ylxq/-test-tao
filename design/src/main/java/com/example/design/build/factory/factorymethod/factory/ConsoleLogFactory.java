package com.example.design.build.factory.factorymethod.factory;

import com.example.design.build.factory.factorymethod.product.ConsoleLog;
import com.example.design.build.factory.factorymethod.product.Log;

public class ConsoleLogFactory  implements LogFactory {
    @Override
    public Log createLog() {
        return new ConsoleLog();
    }
}
