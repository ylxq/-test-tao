package com.example.design.build.factory.abstractfactory.huawei;

import com.example.design.build.factory.abstractfactory.Book;
import com.example.design.build.factory.abstractfactory.Factory;
import com.example.design.build.factory.abstractfactory.Phone;
import com.example.design.build.factory.abstractfactory.Watch;

public class HuaweiFactory implements Factory {
    @Override
    public Book createBook() {
        return new HuaweiBook("华为笔记本");
    }

    @Override
    public Phone createPhone() {
        return new HuaweiP30("huaweip30");
    }

    @Override
    public Watch createWatch() {
        return new HuaweiWatch("华为watch3");
    }
}
