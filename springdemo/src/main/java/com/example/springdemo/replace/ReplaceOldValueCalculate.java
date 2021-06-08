package com.example.springdemo.replace;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class ReplaceOldValueCalculate implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        String input = (String) args[0];
        return input.substring(0,2);
    }

}
