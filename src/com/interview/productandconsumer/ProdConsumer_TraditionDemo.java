package com.interview.productandconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class shareData { //资源类
    private int number=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public  void increment() throws Exception
    {
        lock.lock();
        try {
            //判断
            while (number != 0) {
                //等待，不能生产
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public void decrement() throws Exception
    {
        lock.lock();
        try {
            //判断
            while (number == 0) {
                //等待，不能生产
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
}
/**
 * 传统版的生产者和消费者问题有sync版和lock版（sync，wait，notify）,(lock,await,signalAll)
 * 一个初始值为0的变量，2个线程对其交替操作，一个加一，一个减一，进行5轮
 *
 * 1.线程 操作（方法）  资源类
 * 2.判断 干活 通知
 * 3.防止虚假唤醒机制,即多线程的判断要用while
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        shareData shareData = new shareData();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();

        new Thread(()->{
            for (int i = 1; i <=10; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();
    }
}
