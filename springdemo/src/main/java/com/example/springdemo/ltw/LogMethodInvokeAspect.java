package com.example.springdemo.ltw;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class LogMethodInvokeAspect {

    @Pointcut("execution(public * com.example.springdemo.ltw.LtwBean.*(..))")
    public void pointCut(){

    }


    @Around("pointCut()")
    public void advise(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        System.out.println(signature+" start..... ");
        pjp.proceed();
        System.out.println(signature+" end......");
    }
}
