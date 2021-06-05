package com.example.springdemo.lookup;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy(proxyTargetClass = false)
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode= ScopedProxyMode.TARGET_CLASS) //原型 也就是非单例
public class B {
    public void execute() {
        System.out.println(this);
    }
}
