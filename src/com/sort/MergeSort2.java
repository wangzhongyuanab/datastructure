package com.sort;

import java.util.Arrays;

/**
 * 归并排序,时间复杂度是nlogn
 */
public class MergeSort2 {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];     //归并排序需要一个额外的空间
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr, int left, int right) {
        if (right<=left) return;
        int mid = (left + right) >> 2;         //中间索引 右移一位
        //向左递归分解
        mergeSort(arr, left, mid);
        //向右递归分解
        mergeSort(arr, mid + 1, right);
        //到合并
        merge(arr, left, mid, right);

    }

    //这个也是合并2个有序数组的的一个方法
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[left - left + 1];
        int i = left, j = mid + 1, k = 0;
        //保证i没有循环完，且j没有循环完
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        //第一个while完了,此时就只有2种情况，要么i走完了，要么j走完了
        //如果i还没有走完的话，就让i这个数组剩下的元素赋值给temp
        while (i <= mid) temp[k++] = arr[i++];
        //如果j还没有走完的话，就让j这个数组剩下的元素赋值给temp
        while (j <= right) temp[k++] = arr[j++];
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
        //System.arraycopy(arr,);
        //也可以用System.arraycopy
    }
}
