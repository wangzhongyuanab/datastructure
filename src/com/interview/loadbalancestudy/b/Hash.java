package com.interview.loadbalancestudy.b;

import com.interview.loadbalancestudy.ServerIps;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 12:24
 * 哈希
 */
public class Hash {

    private static final int V_NODES=160;

    //hashcode:ip
    private static SortedMap<Integer,String> virtualMap=new TreeMap<>();
    static{
        for (String ip: ServerIps.lists){
            for (int i = 0; i <V_NODES ; i++) {
                int hash=getHash(ip+"VN"+i);
                virtualMap.put(hash,ip);
            }
        }
    }

    private static String getServer(String client){
        int hash=getHash(client);
        //找大于hash值得第一个结点
        SortedMap<Integer, String> subMap = virtualMap.tailMap(hash);
        Integer firstHash=subMap.firstKey();
        if (firstHash==null){
            firstHash=virtualMap.firstKey();
        }
        return subMap.get(firstHash);
    }

    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        // 如果算出来的值时负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }
}
