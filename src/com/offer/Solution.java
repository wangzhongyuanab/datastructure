package com.offer;

public class Solution {
    public void reOrderArray(int [] array) {
        int index=0;
        int [] newArray=new int[array.length];
        for(int i=0;i<array.length;i++){
            if ((array[i]&1)==1){
                newArray[index+1]=array[i];
            }
        }
        for (int i=0;i<array.length;i++){
            if ((array[i]&1)==0){
                array[index++]=array[i];
            }
        }
        System.arraycopy(newArray,0,array,0,array.length);
    }

    public static void main(String[] args) {
        int a=9,b=6;
        int i=56;
        System.out.println(a+b+","+i);
    }
}
