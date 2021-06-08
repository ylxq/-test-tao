package com.example.hystrixdemo.myself;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author GLNC-taowenchen
 */
public class AbstractMyselfHystrixCommand<R> implements MyselfHystrixCommand<R> {


    private int backleTime = 10;
    private int backlt = 10;
    private Queue queue = new ArrayBlockingQueue(backlt);
    private AtomicBoolean critri = new AtomicBoolean(false);




    @Override
    public R execute() {
        if (critri.get()) {
            return reject();
        }
        try {
            R  r= run();
            //统计success
            return r;
        } catch (Exception e) {
            //统计失败
            return fallBack();
        }
    }

    protected R run() {
        return null;
    }

    protected R fallBack() {
        return null;
    }


    public R reject() {
        throw new IllegalArgumentException("断路器开");
    }
}
