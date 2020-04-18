package com.interview.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 循环比较获取直到成功为止，没有类似wait的阻塞。
 *
 * 通过cas操作完成自旋锁，a线程先进来调用myLock方法自己持有锁5秒，b随后进来后发现当前线程
 * 持有锁，不是null，所以只能自旋等待，直到a释放锁后b随后抢到
 */
public class SpinLockDemo {

    //原子引用线程
    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    public void myLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myUnlock(){
        Thread thread=Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invkoed myunlock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();
            try{ TimeUnit.SECONDS.sleep(5);}catch (InterruptedException e){e.printStackTrace();}
            spinLockDemo.myUnlock();
            },"AAA").start();

        try{ TimeUnit.SECONDS.sleep(1);}catch (InterruptedException e){e.printStackTrace();}

        new Thread(()->{
            spinLockDemo.myLock();
            try{ TimeUnit.SECONDS.sleep(1);}catch (InterruptedException e){e.printStackTrace();}
            spinLockDemo.myUnlock();
        },"BBB").start();

    }

}
