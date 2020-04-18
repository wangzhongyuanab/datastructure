package com.mukewang;

/**
 * 第一版UnionFind,并查集，使用数组模拟了并查集,Quick Find,查找非常快
 */
public class UnionFindOne implements UF {

    private int[] id;

    public UnionFindOne(int size){
        id=new int[size];
        for (int i=0;i<id.length;i++){
            id[i]=i;
        }
    }

    /**
     * 查找元素p所对应的集合编号
     * @param p
     * @return
     */
    private  int find(int p){
        if (p<0||p>=id.length){
            throw new IllegalArgumentException("p is out of bound");
        }
        return id[p];
    }

    /**
     * 合并2个元素所属的集合
     * @param p
     * @param q
     */
    @Override
    public void unionElements(int p, int q) {
        int pID=find(p);
        int qID=find(q);
        if (pID==qID){
            return;
        }
        for (int i=0;i<id.length;i++){
            if (id[i]==pID){
                id[i]=qID;
            }
        }
    }

    /**
     * 查看元素p和q是否所属同一个集合
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
