package com.mukewang;

/**
 * 数组实现的栈
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;
    public ArrayStack(int capacity){
        array=new Array<>(capacity);
    }

    public ArrayStack(){
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
    public E pop() {
        return array.removeLast();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E peek() {
        return array.getLast();
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Stack:");
        builder.append("[");
        for (int i=0;i<array.getSize();i++){
            builder.append(array.get(i));
            if (i!=array.getSize()-1){
                builder.append(",");
            }
        }
        builder.append("] top");
        return builder.toString();
    }
}
