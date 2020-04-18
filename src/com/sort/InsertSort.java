package com.sort;

import java.util.Arrays;

/**
 * 插入排序,时间复杂度也是n2
 */
public class InsertSort {

    public static void main(String[] args) {
        int[]  arr={101,34,119,1};
        insertSort(arr);
    }

    public static void insertSort(int[] arr){
        int insertValue = 0;
        int insertIndex =0;
        for (int i=1;i<arr.length;i++) {
            //第一轮
            //定义待插入的数
            insertValue=arr[i];
            //定义带插入的索引,即arr【1】前面的这个数的下标
            insertIndex =i - 1;
            //给insertValue找到带插入的位置
            //保证再给insertaval找位置时不越界
            //insertValue<arr[insertIndex]待插入的数还没有找到插入位置
            //就需要将arr[insertIndex]后移
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时，说明插入的位置找到，insertIndex+1
            //这儿判断是否需要赋值
            arr[insertIndex+1]=insertValue;
        }
        System.out.println(Arrays.toString(arr));
    }
}
