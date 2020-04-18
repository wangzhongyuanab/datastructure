package com.mukewang;

/**
 * 基于二分搜索树实现的集合
 *   时间复杂度:  增: o(h) o(logn)
 *               查：o(h) o(logn)
 *               删：o(h) o(logn)
 *               h:是二分搜索树的高度
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet(){
        bst=new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
