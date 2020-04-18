package com.test;

import java.util.HashMap;


/**
 * 只出现一次的数字
 */
public class Solution136 {
    public static int singleNumber(int[] nums) {
        int ans=nums[0];
        if (nums.length>1) {
            for (int i = 1; i < nums.length; i++) {
                ans=ans^nums[i];
            }
        }
        return ans;
    }

    public static int singleNumber2(int[] nums) {
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        for (Integer a:map.keySet()){
            if (map.get(a) ==1){
                res=a;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int [] nums={4,1,2,1,2};
        System.out.println(singleNumber2(nums));
    }
}
