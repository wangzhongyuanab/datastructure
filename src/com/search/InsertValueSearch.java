package com.search;

import java.util.Arrays;

/**
 * 插值查找法,插值查找法与二分查找法的区别时mid的确定方法不一样,有序的数组
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr= new int[100];
        for (int i=0;i<100;i++){
            arr[i]=i+1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(insertValueSearch(arr,0,arr.length-1,100));
    }

    /**
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return  如果找到，返回下标，没有找到，返回-1
     */
    public static int insertValueSearch(int []arr,int left,int right,int findVal){
        //findVal<arr[0],findVal>arr[arr.length-1]条件必须需要，不仅可以优化
        //否则，mid可能会越界.
        if (left>right||findVal<arr[0]||findVal>arr[arr.length-1]){
            return -1;
        }
        //求出mid，自适应mid可以减少查找的次数.
        int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];
        if (findVal>midVal){
            return insertValueSearch(arr, mid+1, right, findVal);
        }else if (findVal<midVal){
            return insertValueSearch(arr, left, mid-1, findVal);
        }else {
            return mid;
        }
    }
}
