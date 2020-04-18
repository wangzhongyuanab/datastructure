package com.offer;

import java.util.HashMap;

public class MoreThanHalfNum_Solution {
    public static int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<array.length;i++){
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer)>array.length/2){
                return integer;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ints=new int[]{1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(ints));
    }
}
