package com.interview.lock;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/6 12:31
 */
public class CyClicBarrierTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> sqls=new LinkedBlockingQueue();
        //每当有4个线程处于await状态时，则会触发barrierAction执行
        CyclicBarrier barrier=new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("有4个线程执行了:"+Thread.currentThread());
                for (int i = 0; i <4 ; i++) {
                    System.out.println(sqls.poll());
                }
            }
        });

        for (int i=0;i<10;i++){
            new Thread(()->{
                try {
                    sqls.add("data - "+Thread.currentThread());
                    Thread.sleep(1000L);
                    barrier.await();    //等待栅栏打开，有4个线程都执行到这段代码的时候，才会继续往下执行
                    System.out.println(Thread.currentThread()+"插入完毕");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
