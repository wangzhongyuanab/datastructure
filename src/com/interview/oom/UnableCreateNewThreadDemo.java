package com.interview.oom;

/**
 * 高并发请求服务器的时候，经常出现如下异常，
 * 与平台有关。
 *  1.你的应用创建了太多线程,一个应用进程创建了多个线程，超过系统承载极限
 *  2.服务器不允许你的应用进程创建这么多线程。linux系统默认单个进程可以创建的线程是1024个
 *      超过这个数量，就会报这个错误
 *
 *      java.lang.OutOfMemoryError:unable to create new native thread
 */
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {
        for (int i=1;;i++){
            System.out.println("i:"+i);
            new Thread(()->{
                try{Thread.sleep(Integer.MAX_VALUE);}catch (Exception e){e.printStackTrace();}
            },""+i).start();
        }
    }
}
