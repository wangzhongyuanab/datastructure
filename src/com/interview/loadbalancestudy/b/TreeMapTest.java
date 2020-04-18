package com.interview.loadbalancestudy.b;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 12:39
 * 哈希
 */
public class TreeMapTest {
    public static void main(String[] args) {
        SortedMap<String,Integer> sortedMap=new TreeMap<>();
        sortedMap.put("1",1);
        sortedMap.put("2",2);
        sortedMap.put("3",3);
        sortedMap.put("4",4);
        sortedMap.put("5",5);
        sortedMap.put("6",6);
        sortedMap.put("7",7);
        SortedMap<String, Integer> tailMap = sortedMap.tailMap("2");
        System.out.println(tailMap.firstKey());
        System.out.println(sortedMap.firstKey());
    }
}
