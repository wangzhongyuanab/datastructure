package com.test;

import javax.print.DocFlavor;
import java.util.Arrays;

public class Sum {

    public static int sum(int[] arr){
        return sum(arr,0);
    }

    /**
     * 计算arr【l.....n】这个区间中所有数字的和
     * @param arr
     * @param l
     * @return
     */
    public static int sum(int[] arr,int l){
        if (l==arr.length) {
            return 0;
        }
        return arr[l]+sum(arr,l+1);
    }
}
