package com.sort;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/9 22:58
 */
public class heapSort {
    public static void main(String[] args) {

    }

    static void heapify(int arr[],int length,int i){
        int left=2*i+1,right=2*i+2;
        int largest=i;
        if (left<length&&arr[left]>arr[largest]){
            largest=left;
        }
        if (right<length&&arr[right]>arr[largest]){
            largest=left;
        }
        if (largest!=i){
            int temp=arr[i];arr[i]=arr[largest];arr[largest]=temp;
            heapify(arr, length, largest);
        }
    }

    public static void heapSort(int arr[]){
        if (arr.length==0) return;
        int length=arr.length;
        for (int i = length/2 - 1; i >=0 ; i--) {
            heapify(arr,length,i);
        }
        for (int i = length-1; i>=0 ; i--) {
            int temp=arr[0]; arr[0]=arr[i];arr[i]=temp;
            heapify(arr,i,0);
        }
    }
}
