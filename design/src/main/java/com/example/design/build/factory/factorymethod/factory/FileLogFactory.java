package com.example.design.build.factory.factorymethod.factory;

import com.example.design.build.factory.factorymethod.product.FileLog;
import com.example.design.build.factory.factorymethod.product.Log;

public class FileLogFactory  implements LogFactory{
    @Override
    public Log createLog() {
        return new FileLog();
    }
}
