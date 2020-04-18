package com.sort;

import java.util.Arrays;

/**
 * 归并排序,时间复杂度是nlogn
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        int []temp=new int[arr.length];     //归并排序需要一个额外的空间
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int [] arr,int left,int right,int [] temp){
        if (left<right){
            int mid=(left+right)>>2;         //中间索引 右移一位
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右递归分解
            mergeSort(arr,mid+1,right,temp);
            //到合并
            merge(arr,left,mid,right,temp);
        }
    }
    /**
     *
     * @param arr 排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right     右边索引
     * @param temp      做中转的数组
     */
    public static void merge(int []arr,int left,int mid,int right,int[] temp){
        int i=left; //初始化，左边有序序列的初始索引
        int j=mid+1;  //初始化j，左边有序序列的初始索引
        int t=0;        //指向temp数组的当前索引

        //先把左右两边的数据按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完毕
        while(i<=mid&&j<=right){
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，拷贝到temp数组
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }else {     //反之
                temp[t]=arr[j];
                t+=1;
                j+=1;
            }
        }
        //把有剩余数据的一边的数据依次填充到temp
        while(i<=mid){      //左边的有序序列还有剩余的元素
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while(j<=right){      //左边的有序序列还有剩余的元素
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }
        //将temp数组的元素，拷贝到arr
        //每次并不是都拷贝8个
        t=0;
        int tempLeft=left;
        while(tempLeft<=right){
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }
    }


}
