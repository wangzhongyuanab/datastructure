package com.interview.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

//虚引用，一般和引用队列一起使用，虚引用无法获得对象，可以用来做垃圾回收之前的清理工作,监控这个对象的回收信息
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1=new Object();
        ReferenceQueue<Object> referenceQueue=new ReferenceQueue<>();
        PhantomReference<Object> phantomReference=new PhantomReference<>(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        o1=null;
        System.gc();
        Thread.sleep(500);
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

    }
}
