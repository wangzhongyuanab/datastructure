package com.mukewang;

/**
 * 循环队列
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;       //数组
    private int front ;  //指向队首
    private int tail;       //指向队尾
    private int size;       //队列中有多少元素


    public LoopQueue(int capacity){
        data=(E[])new Object[capacity+1];
        front=0;
        tail=0;
        size=0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if ((tail+1)%data.length==front){
            resize(getCapacity()*2);
        }
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData=(E[]) new Object[newCapacity +1];
        for (int i=0;i<size;i++){
            newData[i]=data[(i+front)%data.length];
        }
        data=newData;
        front=0;
        tail=size;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not dequeue from an empty queue.");
        }
        E ret=data[front];
        data[front] =null;
        front=(front+1)%data.length;
        size--;
        if (size==getCapacity()/4&&getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return ret;
    }


    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("queue is empty");
        }
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("LoopQueue:size= %d,capacity= %d",size,getCapacity()));
        builder.append("front [");
        for (int i=front;i!=tail;i=(i+1)%data.length){
            builder.append(data[i]);
            if ((i+1)%data.length!=tail)
                builder.append(", ");
        }
        builder.append("] tail");
        return builder.toString();
    }
}
