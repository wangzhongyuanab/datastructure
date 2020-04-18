package com.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/14 18:32
 */
public class LRUCache extends LinkedHashMap{

    private final int CACHE_SIZE;

    public LRUCache(int cacheSize){
        super((int)Math.ceil(cacheSize/0.75)+1,0.75f,true);
        //最后一个true表示让linkedhashmap按照访问顺序来进行排序，最近访问的放在头，最老访问的就在尾。
        CACHE_SIZE=cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>CACHE_SIZE;
        //当map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据
    }
}
