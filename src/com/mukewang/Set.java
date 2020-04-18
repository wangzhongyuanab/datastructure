package com.mukewang;

/**
 * 不能添加重复元素
 * @param <E>
 */
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
