package com.interview.lock;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/6 9:17
 */
//抽象队列同步器
//state owner waiters
public class WangAqs {

    //如何判断一个资源的拥有者
    public volatile AtomicReference<Thread> owner=new AtomicReference<>();
    //保存正在等待的线程
    public volatile LinkedBlockingQueue<Thread> waiters=new LinkedBlockingQueue();
    //记录资源状态
    public volatile AtomicInteger state=new AtomicInteger(0);

    //共享资源的逻辑,返回资源的占用情况
    public int tryAcquireShared(){
        throw new UnsupportedOperationException();
    }

    public void acquireShared(){
        boolean addQ=true;
        while (tryAcquireShared()<0){
            if (addQ) {
                //没拿到锁，加入到等待队列
                waiters.offer(Thread.currentThread());
                addQ=false;
            }else {
                //阻塞当前线程
                LockSupport.park();
            }
        }
        waiters.remove(Thread.currentThread());
    }
    public void releaseShared(){
        if (tryReleaseShared()){
            if(owner.compareAndSet(Thread.currentThread(),null)){    //释放成功
                //通知等待者
                Iterator<Thread> iterator = waiters.iterator();
                while (iterator.hasNext()){
                    Thread next = iterator.next();
                    LockSupport.unpark(next);
                }
            }
        }
    }

    public  boolean tryReleaseShared() {
        throw  new UnsupportedOperationException();
    }

    //定义独占资源争用的逻辑，如果没拿到，就等待
    public void acquire(){
        boolean addQ=true;
        while (!tryAcquire()){
            if (addQ) {
                //没拿到锁，加入到等待队列
                waiters.offer(Thread.currentThread());
                addQ=false;
            }else {
                //阻塞当前线程
                LockSupport.park();
            }
        }
        waiters.remove(Thread.currentThread());
    }

    public boolean tryAcquire(){
        //模板方法设计模式
        //交给使用者去实现
        throw new UnsupportedOperationException();
    }

    public void release(){
        if (tryRelease()){
            if(owner.compareAndSet(Thread.currentThread(),null)){    //释放成功
                //通知等待者
                Iterator<Thread> iterator = waiters.iterator();
                while (iterator.hasNext()){
                    Thread next = iterator.next();
                    LockSupport.unpark(next);
                }
            }
        }
    }

    public boolean tryRelease() {
        throw  new UnsupportedOperationException();
    }

    public AtomicInteger getState() {
        return state;
    }

    public void setState(AtomicInteger state) {
        this.state = state;
    }
}
