package com.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 移动零
 */
public class Solution283 {
    public static void moveZeroes(int[] nums) {
//        Queue<Integer> queue=new LinkedList();
//        for(int i=0;i<nums.length;i++) {
//            if (nums[i] != 0) {
//                queue.add(nums[i]);
//            }
//        }
//        for (int i=queue.size();i<nums.length;i++){
//            queue.add(0);
//        }
//        for (int i=0;i<nums.length;i++){
//           nums[i]=queue.remove();
//        }

        // nonzeroIndex 记录非零数应该赋值到的索引位置。
        int nozeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            //第一层判断只操作非零数；第二层判断当前非零数索引值要大于 nonzeroIndex时做移动数据操作
            if (nums[i] != 0) {
                if (i > nozeroIndex) {
                    nums[nozeroIndex] = nums[i];
                    nums[i] = 0;
                }
                nozeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={0,1,0,3,12};
        moveZeroes(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
