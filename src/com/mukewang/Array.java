package com.mukewang;


/**
 * 对数组的二次封装可以得到动态数组
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data=(E[])new Object[capacity];
        size=0;
    }

    public Array(E[] arr){
        data=(E[])new Object[arr.length];
        for (int i=0;i<arr.length;i++){
            data[i]=arr[i];
        }
        size=arr.length;
    }

    public  Array(){
        this(10);
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 获取数组的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 在所有元素后插入一个元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 在所有元素前插入一个元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在第index个位置插入一个元素
     * @param index
     * @param e
     */
    public void add(int index,E e){

        if (index<0||index>size){
            throw new IllegalArgumentException("ADD FAILED.required index>=0 and index<size");
        }
        if (size==data.length){
           //自动扩容
            resize(2*data.length);
        }
        for (int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }

    /**
     * 获取index索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("GET FAILED.index is illegal");
        }
        return data[index];
    }

    //修改index位置上的元素为e
    public  void set(int index,E e){
        data[index]=e;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array:size= %d,capacity= %d",size,data.length));
        builder.append("[");
        for (int i=0;i<data.length;i++){
            builder.append(data[i]);
            if (i!=size-1)
                builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * 查询数组中元素为e所在的索引，如果不存在元素e，则返回-1
     * @param e
     */
    public  int find(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 判断数组中是否存在元素e，存在则返回true，否则返回false
     * @return
     */
    public boolean contains(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     */
    public E remove(int index){
        if (index<0||index>=size){
            throw new IllegalArgumentException("REMOVE FAILED.index is illegal");
        }
        E ret=data[index];
        for (int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null;
        if (size==data.length/4 && data.length/2!=0)
            resize(data.length/2);
        return ret;
    }

    /**
     * 从数组中删除一个元素，返回删除的元素
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素，返回删除的元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除元素e
     */
    public void removeElement(E e){
        int index=find(e);
        if (index!=-1){
            remove(index);
        }
    }

    /**
     * 交换2个索引的元素的位置
     * @param i
     * @param j
     */
    public void Swap(int i,int j){
        if(i<0||i>=size||j<0||j>=size){
            throw new IllegalArgumentException("index is illegal");
        }
        E t=data[i];
        data[i]=data[j];
        data[j]=t;
    }
}
