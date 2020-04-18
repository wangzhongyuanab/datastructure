package com.offer;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers_Solution {
    public static ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input==null||k<=0||k>input.length){
            return result;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<input.length;i++){
            if (i<k){
                priorityQueue.add(input[i]);
            }else if(input[i]<priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(input[i]);
            }
        }
        result.addAll(priorityQueue);
        return result;
    }


    public static void main(String[] args) {
        int[] ints=new int[]{4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution3(ints, 4));
    }
}
