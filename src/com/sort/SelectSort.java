package com.sort;

import java.util.Arrays;

/**
 * 选择排序,时间复杂度为n2
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        selectSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {    //说明假定的最小值不是最小的
                    min = arr[j];     //重置最小值
                    minIndex = j;      //重置最小值的下标。
                }
            }
            if (minIndex != i) {
                //将最小值放在arr【0】,即交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            //第一轮后
            System.out.println("第" + (i + 1) + "轮后:");
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void selectSort2(int[] arr) {
        int minIndex=0,temp=0;
        for(int i=0;i<arr.length-1;i++){
            minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
    }
}

