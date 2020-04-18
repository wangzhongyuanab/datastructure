package com.interview.lock;


import java.util.concurrent.locks.LockSupport;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/5 10:24
 */
public class ParkAndUnpark {
    public static Object baozidian=null;
    public static void main(String[] args) throws InterruptedException {
        //new ParkAndUnpark().suspendResumeTest();
        new ParkAndUnpark().suspendResumeDeadLockTest();
        //new ParkAndUnpark().suspendResumeDeadLockTest2();
        //new ParkAndUnpark().waitAndNotifyTest();
        //new ParkAndUnpark().waitAndNotifyDeadLockTest();
        //new ParkAndUnpark().parkUnparkTest();
        //new ParkAndUnpark().parkUnparkDeadLockTest();
    }


    public void suspendResumeTest() throws InterruptedException {
        Thread consumerThread=new Thread(()->{
            if (baozidian==null){
                System.out.println("进入等待");
                Thread.currentThread().suspend();
            }
            System.out.println("买到包子");
        });
        consumerThread.start();
        Thread.sleep(3000L);
        baozidian=new Object();
        consumerThread.resume();
        System.out.println("通知消费者");
    }

    public void suspendResumeDeadLockTest() throws InterruptedException {
        Thread consumerThread=new Thread(()->{
            if (baozidian==null){
                System.out.println("进入等待");
                try{
                    Thread.sleep(5000L);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Thread.currentThread().suspend();
            }
            System.out.println("买到包子");
        });
        consumerThread.start();
        Thread.sleep(3000L);
        baozidian=new Object();
        consumerThread.resume();
        System.out.println("通知消费者");
    }

    public void suspendResumeDeadLockTest2() throws InterruptedException {
        Thread consumerThread=new Thread(()->{
            if (baozidian==null){
                System.out.println("进入等待");
                synchronized (this) {
                    Thread.currentThread().suspend();
                }
            }
            System.out.println("买到包子");
        });
        consumerThread.start();
        Thread.sleep(3000L);
        baozidian=new Object();
        synchronized (this) {
            consumerThread.resume();
        }
        System.out.println("通知消费者");
    }

    public void waitAndNotifyTest() throws InterruptedException {
       new Thread(()->{
           synchronized (this){
               while (baozidian==null){
                   try{
                       System.out.println("进入等待");
                       this.wait();
                   }catch (InterruptedException e){
                       e.printStackTrace();
                   }
               }
           }
       }).start();
        Thread.sleep(3000L);
        baozidian=new Object();
        synchronized (this){
            this.notifyAll();
            System.out.println("通知消费者");
        }
    }

    public void waitAndNotifyDeadLockTest() throws InterruptedException {
        new Thread(()->{
                while (baozidian==null){
                    try{
                        Thread.sleep(5000L);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                   synchronized (this){
                       try {
                           System.out.println("进入等待");
                           this.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                }
            System.out.println("买到包子");
        }).start();
        Thread.sleep(3000L);
        baozidian=new Object();
        synchronized (this){
            this.notifyAll();
            System.out.println("通知消费者");
        }
    }

    public void parkUnparkTest() throws InterruptedException {
        Thread consumerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(baozidian==null){
                    System.out.println("进入等待");
                    LockSupport.park();
                }
                System.out.println("买到包子");
            }
        });
        consumerThread.start();
        Thread.sleep(3000L);
        baozidian=new Object();
        LockSupport.unpark(consumerThread);
        System.out.println("通知消费者");
    }

    public void parkUnparkDeadLockTest() throws InterruptedException {
        Thread consumerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(baozidian==null){
                    System.out.println("进入等待");
                    synchronized (this) {
                        LockSupport.park();
                    }
                }
                System.out.println("买到包子");
            }
        });
        consumerThread.start();
        Thread.sleep(3000L);
        baozidian=new Object();
        synchronized (this) {
            LockSupport.unpark(consumerThread);
        }
        System.out.println("通知消费者");
    }
}
