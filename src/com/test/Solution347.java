package com.test;

import java.util.*;

/**
 * 前 K 个高频元素,java的优先队列内部实现默认最小堆
 */
public class Solution347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(
                (a,b)->map.get(a)-map.get(b));
        for (int key:map.keySet()){
            if (pq.size()<k){
                pq.add(key);
            }else if (map.get(key)>map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        LinkedList<Integer> res=new LinkedList<>();
        while(!pq.isEmpty()){
            res.add(pq.remove());
        }
        return res;
    }
}
