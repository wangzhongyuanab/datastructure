package com.interview.juc;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("    come in");
        return 1024;
    }
}



/**
 * get（）方法一般放在最后，以防止主线程堵塞
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"AAA").start();
        new Thread(futureTask,"BBB").start();
        while(!futureTask.isDone()){

        }
        int result = futureTask.get();  //要求获得Callable线程的计算结果，如果没有计算完成就要去强求，会导致堵塞，直到计算完成
        System.out.println(futureTask.get());
    }
}
