package com.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 冒泡排序，时间复杂度为n2
 */
public class BobbleSort {
    public static void main(String[] args) {


        int[] arr = {3, 9, -1, 10, -2};

        //第一趟排序就是将最大的数排在最后
        int temp=0;  //临时变量
        boolean flag=false;
        for (int i=0;i<arr.length-1;i++) {
            for (int j = 0; j < arr.length-1; j++) {
                //如果前面的数比后面的数大，就处理
                if (arr[j] > arr[j + 1]) {
                    flag=true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag){   //在一趟排序中，一次交换都没有发生过
                break;
            }else {
                flag=false;
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
