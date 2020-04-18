package com.mukewang;

/**
 * 数组实现的队列
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity){
        array=new Array<>(capacity);
    }

    public ArrayQueue(){
        array=new Array<>();
    }
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Queue:");
        builder.append("front [");
        for (int i=0;i<array.getSize();i++){
            builder.append(array.get(i));
            if (i!=array.getSize()-1){
                builder.append(", ");
            }
        }
        builder.append("] tail");
        return builder.toString();
    }
}
