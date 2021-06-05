package com.example.springdemo.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public  abstract class MainBTest2 {

    public void  execute(){
        B b = createB();
        b.execute();
    }

    @Lookup
    protected abstract   B createB();


}
