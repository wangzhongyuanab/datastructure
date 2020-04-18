package com.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class shareResource{
    private int number=1;     //A:1,b:2,c:3

    private Lock lock=new ReentrantLock();
    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            //判断
            while (number!=1){
                c1.await();
            }
            //干活
            for (int i=1;i<=5;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知2号线程
            number=2;
            c2.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try{
            //判断
            while (number!=2){
                c2.await();
            }
            //干活
            for (int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知3号线程
            number=3;
            c3.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            //判断
            while (number!=3){
                c3.await();
            }
            //干活
            for (int i=1;i<=15;i++){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知1号线程
            number=1;
            c1.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * sync和lock的区别
 *  多线程之间按顺序调用，实现A->B->C启动
 *  A打印5次
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        shareResource shareResource = new shareResource();
        new Thread(()->{
            for (int i = 1; i <=1; i++) {
                shareResource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <=1; i++) {
                shareResource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <=1; i++) {
                shareResource.print15();
            }
        },"C").start();
    }
}
