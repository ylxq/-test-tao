package com.example.tao.testdemo.multiThread;

import java.util.concurrent.TimeUnit;

public class ThreadMain {
    static  int abc = 0;
     int a = 1;
     boolean status = false;

     public void change(){

         a = 2;   //1
         status = true;  //2

     }

     public void show(){
         if(status){   //3
             int b = a + 1;  //4
             System.out.println(b);
         }

     }
    public static void main(String[] args) throws InterruptedException {

        ThreadMain threadMain = new ThreadMain();
        new Thread(() -> {
            threadMain.change();
        }).start();


        new Thread(() -> {
            threadMain.show();

        }).start();

    }


/*
     java并发编程 三个特性

      原子性     操作的完整性，不可分割。
      锁

      可见性     某个线程更改了共享变量 其他线程能够及时获取最新的值
      volatile
      锁

      有序性     按照代码顺序执行（指令重排）

      volatile
      锁
*/
}
