package com.interview.juc;


import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/6 16:01
 */
public class WangFutureTask<T> implements Runnable, Future {

    Callable<T> callable;
    T result=null;
    volatile String state="NEW";    //task执行状态
    LinkedBlockingQueue<Thread> waiters=new LinkedBlockingQueue<>();

    public WangFutureTask(Callable<T> callable){
        this.callable=callable;
    }
    @Override
    public void run() {
        try {
            result=callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            state="END";
        }
        //唤醒等待者
        Thread waiter=waiters.poll();
        while (waiter!=null){
            LockSupport.unpark(waiter);
            waiter=waiters.poll();  //继续取出队列中的等待者
        }
    }

    @Override
    public T get(){
        if ("END".equals(state)){
            return result;
        }
        //如果没有结束，那么调用get方法的线程就应该进入等待
        waiters.offer(Thread.currentThread());
        while(!"END".equals(state)){
            LockSupport.park();
        }
        return result;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }



    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
