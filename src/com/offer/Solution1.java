package com.offer;

public class Solution1 {
    public static  boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if (target==array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static  boolean Find1(int target, int [][] array) {
        int row=array.length;
        int col=array[0].length;
        for(int i=0,j=col-1;i<row&&j>=0;){
            if(target == array[i][j]) {
                return true;
            }
            //小于当前值，则左移
            if(target < array[i][j]) {
                j--;
            } else if(target > array[i][j]) { //大于当前值，则下移
                i++;
            }
        }
        return false;
    }


    public static  boolean Find2(int target, int [][] array) {
        int row=array.length;
        int col=array[0].length;
        if (row==0||col==0){
            return false;
        }
        int r=0;
        for(;r<row&&array[r][col-1]<target;r++);
        for(;r<row;r++){
                int low=0;
                int high=col-1;
                while(low<=high) {
                    int mid=low+(high-low)/2;
                    if (target == array[r][mid]) {
                        return true;
                    } else if (target < array[r][mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        return  false;
    }
    
    public static void main(String[] args) {
        int [][] array=new int[][]{{1,2,8,9,},{2,4,9,12,},{4,7,10,13,},{6,8,11,15}};
        int target=7;
        System.out.println(Find2(target, array));
    }
}
