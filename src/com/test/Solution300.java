package com.test;

public class Solution300 {
    public static int lengthOfLIS(int[] nums) {
        int len=nums.length;
        if (len <= 1) {
            return len;
        }

        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;
        for(int i=1;i<len;i++){
            if (nums[i]>tail[end]){
                end++;
                tail[end]=nums[i];
            }else{
                int left=0;
                int right=end;
                while(left<right){
                    int mid=left+((right-left)>>>1);
                    if(tail[mid]<nums[i]){
                        left=mid+1;
                    }else{
                        right=mid;
                    }
                }
                tail[left]=nums[i];
            }
        }
        end++;
        return end;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        int lengthOfLIS = lengthOfLIS(nums);
        System.out.println("最长上升子序列的长度：" + lengthOfLIS);
    }
}
