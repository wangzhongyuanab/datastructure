package com.interview.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/5 22:48
 */
public class LongAdderDemo {
    private long count=0;

    //同步代码块的方式
    public void testSync(){
        for (int i=0;i<3;i++){
            new Thread(()->{
                long starttime=System.currentTimeMillis();
                while(System.currentTimeMillis()-starttime<2000){
                    synchronized (this){
                        ++count;
                    }
                }
                long endtime=System.currentTimeMillis();
                System.out.println("SyncThread spend"+(endtime-starttime)+"ms"+"v"+count);
            }).start();
        }
    }


    //Atomic方式
    private AtomicLong acount=new AtomicLong(0L);
    public void testAtomic(){
        for (int i=0;i<3;i++) {
            new Thread(() -> {
                long starttime = System.currentTimeMillis();
                while (System.currentTimeMillis() - starttime < 2000) {
                    synchronized (this) {
                        acount.incrementAndGet();
                    }
                }
                long endtime = System.currentTimeMillis();
                System.out.println("AtomicLong spend" + (endtime - starttime) + "ms" + "v" + acount.get());
            }).start();
        }
    }

    //LongAdder方式
    private LongAdder lcount=new LongAdder();
    public void testLongAdder() {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                long starttime = System.currentTimeMillis();
                while (System.currentTimeMillis() - starttime < 2000) {
                    synchronized (this) {
                        lcount.increment();
                    }
                }
                long endtime = System.currentTimeMillis();
                System.out.println("LongAdder spend" + (endtime - starttime) + "ms" + "v" + lcount.sum());
            }).start();
        }
    }

    public static void main(String[] args) {
        LongAdderDemo longAdderDemo=new LongAdderDemo();
        longAdderDemo.testSync();
        longAdderDemo.testAtomic();
        longAdderDemo.testLongAdder();
    }
}
