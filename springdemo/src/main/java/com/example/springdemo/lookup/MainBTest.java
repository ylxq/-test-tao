package com.example.springdemo.lookup;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public  class MainBTest implements ApplicationContextAware {

    public void  execute(){
        B b = createB();
        b.execute();
    }

    protected  B createB(){
        return this.applicationContext.getBean(B.class);
    }



    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(
            ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
