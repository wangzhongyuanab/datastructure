package com.interview;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 集合类不安全的问题
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        Map<String,String> map= new ConcurrentHashMap<>();//Collections.synchronizedMap(new HashMap<>());//new HashMap();
        /**
         * Collections.synchronizedSet(new HashSet<>())
         * new CopyOnWriteArraySet<>()
         */
        for (int i = 1; i <=30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    public static void setNotSafe(){
        Set<String> set= new HashSet<>();
        /**
         * Collections.synchronizedSet(new HashSet<>())
         * new CopyOnWriteArraySet<>()
         */
        for (int i = 1; i <=30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    public static void listNotSafe(){
        List<String> list= Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <=30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        /**
         * java.util.ConcurrentModificationException
         * 原因：并发争抢修改导致。一个人正在写，一个人来抢夺，导致数据不一致，并发修改异常。
         */

        /**
         * 解决方案：
         *  new Vector()
         *  Collections.synchronizedList
         *  juc包中的CopyOnWriteArrayList：写时复制。往一个容器添加元素的时候，不直接往当前容器Object[]添加，而是先将当前容器object[]进行copy，
         *  复制出一个新的容器object[] newElements,然后往新的容器中添加元素，添加完元素之后，再将原容器的引用指向新的容器setArray(newElements);
         *  这样做的好处是可以对CopyOnWrite容器进行并发的读，而不需要加锁，因为当前容器不会添加任何元素（读写分离的思想），读和写不同的容器
         */
    }
}
