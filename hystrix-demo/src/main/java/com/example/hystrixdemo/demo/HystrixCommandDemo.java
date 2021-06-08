package com.example.hystrixdemo.demo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.TimeUnit;

/**
 * @author GLNC-taowenchen
 */
public class HystrixCommandDemo extends HystrixCommand<Integer> {


    protected HystrixCommandDemo() {
        super(HystrixCommandGroupKey.Factory.asKey("MyCommandGroup"));
    }

    @Override
    protected Integer run() throws Exception {
        boolean circuitBreakerOpen = this.isCircuitBreakerOpen();
        if (circuitBreakerOpen) {
            System.out.println("重试一次=================");
            return 1;
        }
        return 1 / 0;
    }

    @Override
    protected Integer getFallback() {
        boolean circuitBreakerOpen = this.isCircuitBreakerOpen();
        if (circuitBreakerOpen) {
            System.out.println("断路器开");
        }

        return -1;
    }

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            TimeUnit.MILLISECONDS.sleep(200);
            HystrixCommandDemo command = new HystrixCommandDemo();
            Integer result = command.execute();
            System.out.println(result);
        }

    }
}
