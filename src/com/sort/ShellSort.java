package com.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr={8,9,1,7,2,3,5,4,6,0};
        shellSort2(arr);
    }

    /**
     * (交换法)
     * @param arr
     */
    public static void shellSort(int []arr){

        int temp=0;
        int count=0;
        for (int gap=arr.length/2;gap>0;gap/=2) {
            //第一轮
            //将10个数据分成了5组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共gap组，每组有个元素,步长gap）
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第"+(++count)+"轮后：" + Arrays.toString(arr));
        }
    }

    /**
     * 移位法
     * @param arr
     */
    public static void shellSort2(int[] arr){
        int count=0;
        //仍然使用增量gap，并逐步缩小gap
        for (int gap=arr.length/2;gap>0;gap/=2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if (arr[j]<arr[j-gap]){
                    while(j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    //当退出while循环时，就给temp找到待插入的位置
                    arr[j]=temp;
                }
            }
            System.out.println("希尔排序第"+(++count)+"轮后：" + Arrays.toString(arr));
        }
    }
}
