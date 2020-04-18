package com.interview.lock;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/5 21:00
 */
//自己实现（独享锁）
public class WangLock implements Lock {

   WangAqs aqs=new WangAqs(){

       @Override
       public boolean tryAcquire() {
           return owner.compareAndSet(null,Thread.currentThread());
       }

       @Override
       public boolean tryRelease(){
            return owner.compareAndSet(Thread.currentThread(),null);
       }
   };

    @Override
    public void lock() {
        aqs.acquire();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }


    @Override
    public boolean tryLock() {
       return aqs.tryAcquire();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public void unlock() {
        aqs.release();
    }

    @Override
    public Condition newCondition() {
        return null;
    }

}
