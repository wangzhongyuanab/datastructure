package com.sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr={53,3,542,748,14,214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        //得到数组中最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        //二维数组包含10个一维数组，为了防止在放入数的时候，数据溢出，大小只能定为arr.length
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数据,定义一个一维数组来记录每个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];
        //每一轮排序（针对每个元素的个位数进行排序处理）
        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的对应的位值
                int digitOfElement = arr[j] /n% 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            //遍历每个桶，并将每个桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，才放入到原数组，
                if (bucketElementCounts[k] != 0) {
                    //循环该桶，即第k个一维数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第一轮处理后，需要将每个bucketElementCounts【k】置0
                bucketElementCounts[k] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
