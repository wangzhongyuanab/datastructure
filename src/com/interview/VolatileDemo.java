package com.interview;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {

    static Unsafe unsafe;   //直接操作内存，修改对象
    private static long numberOffset=0;

    static{
        try{
            //使用反射机制获取unsafe值
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            //获取到number属性的偏移量(用于定位number在内存中的具体地址)
            numberOffset=unsafe.objectFieldOffset(MyData.class.getDeclaredField("number"));
        }catch (Exception ex){
        }
    }

    volatile int number = 0;


    public void addTo60() {
        this.number = 60;
    }

    public void addPlusPlus() {
        //number++; //java层面 3个步骤
        //采用cas循环+重试
        int current;
       do{
        current=unsafe.getIntVolatile(this,numberOffset);
       }while (!unsafe.compareAndSwapInt(this,numberOffset,current,current+1));
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addMyAtomic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * 验证volatile的可见性
 */
public class VolatileDemo {

    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        //等待上面20个线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value:" + myData.atomicInteger);
    }

    public void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                //暂停线程
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated number value:" + myData.number);
        }, "AAA").start();


        //第二个线程就是我们的main线程
        while (myData.number == 0) {
            //main线程就一直在这里等待循环，直到number不再等于0
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over,main get number:" + myData.number);
    }
}
