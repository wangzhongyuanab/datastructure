package com.sort;

import java.util.Arrays;

/**
 * 快速排序,时间复杂度是nlogn
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={-9,78,0,23,-567,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int []arr,int left,int right){
        int l=left;     //左下标
        int r=right;    //右下标
        int pivot=arr[(left+right)/2];
        int temp=0;         //临时变量,作为交换时使用
        //while循环的目的是让比pivot小的值放到左边
        //比pivot大的值放到右边
        while (l<r){
            //在pivot的左边一直找，找到大于或者等于pivot的值才推出
            while (arr[l]<pivot){
                l+=1;
            }
            //在pivot的右边一直找，找到小于或者等于pivot的值才推出
            while(arr[r]>pivot){
                r-=1;
            }
            //如果l>=r成立，说明pivot2边的值已经按照左边全部是小于等于pivot的值，右边全部是大于等于pivot的值
            if (l>=r){
                break;
            }
            //交换
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //如果交换完后，发现arr【l】==pivot值，r--前移
            if (arr[l]==pivot){
                r-=1;
            }
            if (arr[r]==pivot){
                l+=1;
            }
        }
        if (l==r){
            l+=1;
            r-=1;
        }
        //向左递归
        if (left<r){
            quickSort(arr,left,r);
        }
        //向右递归
        if (right>l){
            quickSort(arr,l,right);
        }
    }
}
