package com.interview.lock;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量：
 * 用于多个共享资源的互斥使用，用于并发线程数的控制
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //模拟3个停车位
        Semaphore semaphore=new Semaphore(3);
        //模拟6个车
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位");
                    //每个车停3秒
                    try{ TimeUnit.SECONDS.sleep(3);}catch (InterruptedException e){e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName()+"\t 停车3秒后离开");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
