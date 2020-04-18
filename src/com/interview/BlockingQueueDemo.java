package com.interview;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue:是一个基于数组结构的有界阻塞队列，此队列按fifo(先进先出)原则对元素进行排序
 * linkedBlockingQueue:一个基于链表的阻塞队列，此队列按fifo排序元素，吞吐量要高于ArrayBlockingQueue.
 * SynchronousQueue:一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量高于linkedBlockingQueue
 *
 *  当阻塞队列是空时，从队列里获取元素的操作将被阻塞
 *  当阻塞队列是满时，从队列里添加元素的操作将会被阻塞
 *
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception
    {
        //        //List list=null;
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        //System.out.println(blockingQueue.offer("x", 2L, TimeUnit.SECONDS));
        //System.out.println(blockingQueue.offer("x", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
        //System.out.println(blockingQueue.poll(2L, TimeUnit.SECONDS));
    }
}
