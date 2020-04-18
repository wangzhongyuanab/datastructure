package com.mukewang;

/**
 * 并查集
 */
public interface UF {
    void unionElements(int p,int q);
    boolean isConnected(int p,int q);
    int getSize();
}
