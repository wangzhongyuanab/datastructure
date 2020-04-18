package com.search;

import java.util.ArrayList;
import java.util.List;

/*
*二分查找,前提数组必须是有序的
 */
public class BinarySearch {

    public static void main(String[] args) {
        int []arr={1,8,10,89,1000,1000,1000,1234};
        System.out.println(binarySearch2(arr,0,arr.length-1,1000));
    }

    //查询一个数
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        //当left>right时，说明递归整个数组，但是没有找到
        if (left>right){
            return -1;
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if (findVal>midVal){
           return  binarySearch(arr, mid+1, right, findVal);
        }else if (findVal<midVal){
           return  binarySearch(arr, left, mid-1, findVal);
        }else {
            return mid;
        }
    }

    //查询数，但是可以查出相同的数
    public static List<Integer> binarySearch2(int[] arr,int left,int right,int findVal){
        //当left>right时，说明递归整个数组，但是没有找到
        if (left>right){
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if (findVal>midVal){
            return  binarySearch2(arr, mid+1, right, findVal);
        }else if (findVal<midVal){
            return  binarySearch2(arr, left, mid-1, findVal);
        }else {
            //在找到mid索引时，不要马上返回，在向mid索引的左边扫描，将所有满足1000的元素的下标加入得到集合ArrayList，在向mid索引的右边扫描，将所有满足1000的元素的下标加入得到集合ArrayList
            List<Integer> list = new ArrayList<>();
            int temp=mid-1;
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
                //否则就将temp放入到集合中。
                list.add(temp);
                temp-=1;
            }
            list.add(mid);

            temp=mid+1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=findVal){
                    break;
                }
                //否则就将temp放入到集合中。
                list.add(temp);
                temp+=1;
            }
            return list;
        }
    }

}
