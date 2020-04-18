package com.sort;

import java.util.Arrays;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/3 23:15
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr={-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] a,int begin,int end){
        if (end<=begin) return;
        int privot=partion(a,begin,end);
        quickSort(a,begin,privot-1);
        quickSort(a,privot+1,end);
    }

    private static int partion(int[] a, int begin, int end) {
        //pivot:标杆位置，counter：小于pivot的元素的个数
        int pivot=end,counter=begin;
        for (int i=begin;i<end;i++){
            if (a[i]<a[pivot]){
                int temp=a[counter];
                a[counter]=a[i];
                a[i]=temp;
                counter++;
            }
        }
        int temp=a[pivot];
        a[pivot]=a[counter];
        a[counter]=temp;
        return counter;
    }
}
