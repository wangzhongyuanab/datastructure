package com.mukewang;

/**
 * 线段树的融合器
 * @param <E>
 */
public interface Merger<E> {
    E merge(E a,E b);
}
