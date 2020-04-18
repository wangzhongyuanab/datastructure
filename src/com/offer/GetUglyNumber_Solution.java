package com.offer;

public class GetUglyNumber_Solution {
    public static  int GetUglyNumber_Solution(int index) {
        if(index<7){
            return index;
        }
        int count=0;
        for(int i=7;;i++){
            if(isUgly(i)){
                count++;
                if(count==index){
                    return i;
                }
            }
        }
    }

    public static boolean isUgly(int i){
        while(i%2==0){
            i/=2;
        }
        while(i%3==0){
            i/=3;
        }
        while(i%5==0){
            i/=5;
        }
        return i==1;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(1));
    }
}
