package com.interview.lock;


import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁的测试
public class Cache {
    static Map<String,Object> map=new HashMap<String,Object>();
    static ReentrantReadWriteLock rwl=new ReentrantReadWriteLock();
    static Lock r=rwl.readLock();
    static Lock w=rwl.writeLock();

    //获取一个key对应的value
    public static final Object get(String key){
        r.lock();
        try{
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    //设置key对应的value，并返回旧的value
    public static final Object put(String key,Object value){
        w.lock();
        try{
            return map.put(key, value);
        }finally {
            w.unlock();
        }
    }

    public static final void clear(){
        w.lock();
        try{
            map.clear();
        }finally {
            w.unlock();
        }
    }
}
