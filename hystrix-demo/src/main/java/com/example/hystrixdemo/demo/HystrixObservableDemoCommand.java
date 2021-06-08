package com.example.hystrixdemo.demo;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixObservableCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsPoller;
import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 * @author GLNC-taowenchen
 */

public class HystrixObservableDemoCommand extends HystrixObservableCommand<String> {


    public HystrixObservableDemoCommand(Setter setter) {
        super(setter);
    }

    @Override
    protected String getFallbackMethodName() {
        return "resumeWithFallback";
    }

    @Override
    protected Observable<String> resumeWithFallback() {
        if (isCircuitBreakerOpen()) {
            System.out.println("断路器开");
        }
        return Observable.just("-1");
    }

    @Override
    protected Observable<String> construct() {
        if (isCircuitBreakerOpen()) {
            System.out.println("重试一次");
            return Observable.just("1");
        }
        System.out.println("正常调用");
        try {
            TimeUnit.MILLISECONDS.sleep(201);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Observable.just(1 / 0 + "");
    }

    public static void main(String[] args) throws InterruptedException {
        HystrixMetricsPoller poller = new HystrixMetricsPoller(json -> {
            System.out.println(json);
        }, 1000);
        test(poller);
    }

    public static void test(HystrixMetricsPoller poller) throws InterruptedException {
        HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("my-test-HystrixObservableCommand-group");
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("my-test-HystrixObservableCommand-command");

        final HystrixCommandProperties.Setter propertiesSetter =
                HystrixCommandProperties.Setter()
                        // .withCircuitBreakerForceOpen(true); 强制开启断路器
//                        .withCircuitBreakerForceClosed(true) 强制关闭断路器
//                        .withMetricsRollingStatisticalWindowInMilliseconds(10000) 滚动窗口时间
//                        .withMetricsRollingStatisticalWindowBuckets(7) 滚动窗口-统计的请求数
                        .withExecutionTimeoutInMilliseconds(100)
                        .withCircuitBreakerEnabled(true)
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(100)
                        .withCircuitBreakerErrorThresholdPercentage(50)
                        .withCircuitBreakerRequestVolumeThreshold(20)
                        .withCircuitBreakerSleepWindowInMilliseconds(5000);


        Setter setter = Setter
                .withGroupKey(groupKey)
                .andCommandKey(commandKey)
                .andCommandPropertiesDefaults(propertiesSetter);

        poller.start();
        while (true) {
            TimeUnit.MILLISECONDS.sleep(200);
            HystrixObservableDemoCommand command = new HystrixObservableDemoCommand(setter);
            command.observe().subscribe(System.out::println);

        }
    }



}
