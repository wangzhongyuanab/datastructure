package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 求众数
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> counts=new HashMap<Integer,Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
}
