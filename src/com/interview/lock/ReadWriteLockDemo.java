package com.interview.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class MyCache     //资源类
{
    private volatile Map<String,Object> map=new HashMap<>();
    //private Lock lock=new ReentrantReadWriteLock();
    private ReentrantReadWriteLock rwLock=new ReentrantReadWriteLock();

    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入:"+key);
            //暂停一会儿线程
            try{
                TimeUnit.MILLISECONDS.sleep(300);}catch(InterruptedException e){e.printStackTrace();}
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成:");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key){
        rwLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在读取:");
            //暂停一会儿线程
            try{
                TimeUnit.MILLISECONDS.sleep(300);}catch(InterruptedException e){e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t 读取完成:"+map.get(key));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }

    public void clearMap(){
        map.clear();
    }
}
/**
 * 多个线程同时读一个资源类没有问题，所有为了满足并发量，读取共享资源可以同时进行
 * 但是如果有一个线程想去写共享资源，就不应该再有其他线程可以对该资源进行读或写
 *
 *      读-读能共存
 *      读-写不能共存
 *      写-写不能共存
 *
 *      写操作：原子+独占，中间整个过程必须是一个完整的统一体，中间不能被打断
 */
public class ReadWriteLockDemo
{
    public static void main(String[] args)
    {
        MyCache myCache = new MyCache();
        for (int i = 1; i <=5; i++) {
            final int tempInt=i;
            new Thread(()->{
                myCache.put(tempInt+"",tempInt+"");
            },String.valueOf(i)).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }

        for (int i = 1; i <=5; i++) {
            final int tempInt=i;
            new Thread(()->{
                myCache.get(tempInt+"");
            },String.valueOf(i)).start();
        }

    }
}
