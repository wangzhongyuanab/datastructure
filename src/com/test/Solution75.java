package com.test;

/**
 *  颜色分类
 */
public class Solution75 {
    //计数排序
    public static void sortColors(int[] nums) {
//        int count[]=new int[3];     //存放0，1，2  3个元素的频率
//        for (int i=0;i<nums.length;i++){
//            assert(nums[i]>=0&&nums[i]<=2);
//            count[nums[i]]++;
//        }
//
//        int index=0;
//        for (int i=0;i<count[0];i++){
//            nums[index++]=0;
//        }
//        for (int i=0;i<count[1];i++){
//            nums[index++]=1;
//        }
//        for (int i=0;i<count[2];i++){
//            nums[index++]=2;
//        }
        //采用三路快排
        int zero=-1;
        int two=nums.length;
        for (int i=0;i<two;){
            if (nums[i]==1){
                i++;
            }else if (nums[i]==2){
                int a=nums[--two];
                nums[i]=a;
                nums[two]=2;
            }else{
                assert (nums[i]==0);
                int b=nums[++zero];
                nums[zero]=nums[i];
                nums[i]=b;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int []arr={2,0,2,1,1,0};
        sortColors(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
