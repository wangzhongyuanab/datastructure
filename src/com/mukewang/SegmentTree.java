package com.mukewang;


/**
 * 基于数组实现的线段树
 * 如果区间有n个元素，数组需要有4n的空间
 * 不考虑添加元素即静态区间固定
 * 对线段树的问题:对于一个区间的更新。
 * @param <E>
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;
    public SegmentTree(E[] arr,Merger merger){
        this.merger=merger;
        data=(E[])new Object[arr.length];
        for (int i=0;i<arr.length;i++){
            data[i]=arr[i];
        }
        tree=(E[])new Object[4*arr.length];
        buildSegmentTree(0,0,data.length-1);
    }

    /**
     * 构造从【l。。。r】区间为线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l==r){
            tree[treeIndex]=data[l];
            return ;
        }
        int leftIndex=leftChild(treeIndex);
        int rightIndex=rightChild(treeIndex);

        int mid=l+(r-l)/2;
        buildSegmentTree(leftIndex,l,mid);
        buildSegmentTree(rightIndex,mid+1,r);
        tree[treeIndex]=merger.merge(tree[leftIndex],tree[rightIndex]);

    }


    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if (index<0||index>=data.length){
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return 2*index+1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return 2*index+2;
    }

    public E query(int queryL,int queryR){
        if (queryL<0||queryL>=data.length||queryR<0||queryR>=data.length||queryL>queryR){
            throw new IllegalArgumentException("index is illegal");
        }
        return query(0,0,data.length-1,queryL,queryR);
    }

    /**
     * 在以tree ID为根的线段树中【l...r】的范围里，搜索区间【queryL。。。 queryR】的值
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex,int l ,int r,int queryL,int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        //当区间全部落在右子树时
        if (queryL >= mid + 1) {
            return query(rightIndex, mid + 1, r, queryL, queryR);
            //当区间全部落在左子树时
        } else if (queryR <= mid) {
            return query(leftIndex, l, mid, queryL, queryR);
        }
        //当区间一部分在左子树，一部分在右子树
        E leftResult=query(leftIndex,l,mid,queryL,mid);
        E rightResult=query(rightIndex,mid+1,r,mid+1,queryR);
        return merger.merge(leftResult,rightResult);
    }

    /**
     * 将index位置得值，更新为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index<0||index>=data.length){
            throw new IllegalArgumentException("index is illegal");
        }
        data[index]=e;
        set(0,0,data.length-1,index,e);
    }

    /**
     * 在以treeIndex为根的线段树中跟新index位置的元素为e
     * @param treeIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void set(int treeIndex,int l,int r,int index,E e){
        if (l==r){
            tree[treeIndex]=e;
            return;
        }
        int mid=l+(r-l)/2;
        int leftTreeIndx=leftChild(treeIndex);
        int righrTreeChild=rightChild(treeIndex);

        if (index>=mid+1){
            set(righrTreeChild,mid+1,r,index,e);
        }else{
            set(leftTreeIndx,l,mid,index,e);
        }
        tree[treeIndex]=merger.merge(tree[leftTreeIndx],tree[righrTreeChild]);
    }
}
