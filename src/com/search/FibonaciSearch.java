package com.search;

import java.util.Arrays;

/**
 * 斐波那契查找,也限定数组是有序数组
 */
public class FibonaciSearch {
    public static int maxSize=20;
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr,87));
    }

    /**
     * 后面要使用mid=low+F（k-1）-1，需要使用到斐波那契数列，因此需要先获取到一个斐波那契数列,非递归
     * @return
     */
    public static int[] fib(){
        int[] f=new int[20];
        f[0]=1;
        f[1]=1;
        for (int i=2;i<maxSize;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }


    /**
     * 斐波那契查找算法,非递归
     * @param a
     * @param key
     * @return
     */
    public static int  fibSearch(int []a,int key){
        int low=0;
        int high=a.length-1;
        int k=0;  //表示斐波那契分割数值的下标
        int mid=0;
        int f[]=fib();      //获取到斐波那契数列
        //获取到k
        while (high>f[k]-1){
            k++;
        }
        //因为f[k]可能大于数组的长度，因此我们使用一个Arrays列，构造一个新的数组，并指向temp[]
        //不足的部分会使用0填充
        int []temp= Arrays.copyOf(a,f[k]);
        //实际上需要使用a数组最后的数填充temp
        for (int i=high+1;i<temp.length;i++){
            temp[i]=a[high];
        }
        while (low<=high){
             mid=low+f[k-1]-1;
             if (key<temp[mid]){        //向数组的前面查找
                high=mid-1;
                k--;       //全部元素=前面的元素+后面的元素，f[k]=f[k-1]+f[k-2]因为前面有f【k-1】个元素，所以可以继续拆分,即下次循环mid=f[k-1-1]-1
             }else if (key>temp[mid]){      //向数组的后面查找
                 low=mid+1;
                 k-=2;      //全部元素=前面的元素+后面的元素，f[k]=f[k-1]+f[k-2]，后面还有f【k-2】个元素，所以可以继续拆分,即在f【k-2】的前面继续查找。即下次循环mid=f[k-1-2]-1
             }else {
                 //需要确定的时返回的是哪个下标
                 if (mid<=high){
                     return mid;
                 }else {
                     return high;
                 }
             }
        }
        return -1;
    }
}
