package com.mukewang;

/**
 * 基于数组实现的最大堆(二叉堆)，同时还有d叉堆，索引堆,二项堆，斐波那契堆。
 *      add和extractMax时间复杂度都是o（logn）,用heapify实现一个堆比一个一个的放进堆要快很多，即先把这个数组放进堆里，再对这个堆进行整理。
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data=new Array<>(capacity);
    }

    public MaxHeap(){
        data=new Array<>();
    }

    /**
     * 将任意数组整理成堆的形态.heapify
     */
    public MaxHeap(E[] arr){
        data=new Array<>(arr);
        for (int i=parent(arr.length-1);i>=0;i--){
            SiftDown(i);
        }
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if (index==0)
            throw new IllegalArgumentException("index-0 does not have parent.");
        return (index-1)/2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的节点。
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index*2+1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的节点。
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index*2+2;
    }

    /**
     * 向堆中添加元素
     */
    public void add(E e){
        data.addLast(e);
        SiftUp(data.getSize()-1);
    }

    /**
     * 添加元素后需要比较该元素和其父节点的大小，需要调整位置。
     * @param k
     */
    private void SiftUp(int k) {
        while(k>0&&data.get(parent(k)).compareTo(data.get(k))<0){
            data.Swap(k,parent(k));
            k=parent(k);
        }
    }

    /**
     * 看堆中大的最大元素
     * @return
     */
    public E findMax(){
        if (data.getSize()==0){
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }
    /**
     * 取出最大堆中的最大值,让索引为0的元素和最后一个元素交换，然后删除最后一个元素，最后让索引为0的元素做下沉操作。
     */
    public E extractMax(){
        E ret=findMax();
        data.Swap(0,data.getSize()-1);
        data.removeLast();
        SiftDown(0);
        return ret;
    }

    /**
     * 下沉
     * @param k
     */
    private void SiftDown(int k) {
        while (leftChild(k)<data.getSize()){
            int j=leftChild(k);
            //有右孩子
            if (j+1<data.getSize()&&
                data.get(j+1).compareTo(data.get(j))>0){
                j=rightChild(k);
                //data[j]是leftChild和rightChild中的最大值
            }
            if (data.get(k).compareTo(data.get(j))>=0){
                break;
            }
            data.Swap(k,j);
            k=j;
        }
    }

    /**
     * 取出堆中的最大值，并且替换成元素e
     * @return
     */
    public E replace(E e){
        E ret=findMax();
        data.set(0,e);
        SiftDown(0);
        return ret;
    }
}
