package com.interview.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Ticket{
    private int number=30;
    private Lock lock=new ReentrantLock();
    public void saleTicket(){
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第：" + (number--) + "\t 还剩下:" + number);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 1; i <=40 ; i++) {
                ticket.saleTicket();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <=40 ; i++) {
                ticket.saleTicket();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <=40 ; i++) {
                ticket.saleTicket();
            }
        },"C").start();
    }
}
