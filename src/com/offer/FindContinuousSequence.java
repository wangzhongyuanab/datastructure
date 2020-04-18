package com.offer;

import java.util.ArrayList;

public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(sum <= 2) {
            return result;
        }
        int left=1,right=2,tempSum=3;
        while(left<right){
            if(tempSum<sum){
                right++;
                tempSum+=right;
            }else if (tempSum>sum){
                tempSum-=left;
                left++;
            }else{
                ArrayList<Integer> temp=new ArrayList<>();
                for(int i=left;i<=right;i++){
                    temp.add(i);
                }
                result.add(temp);
                tempSum-=left;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(100));
    }
}
