package com.interview.codeandtest;

import java.util.Arrays;

public class Exam4 {
    public static void main(String[] args) {
        int i=1;
        String str="hello";
        Integer num=200;
        int [] arr={1,2,3,4,5};
        MyData my = new MyData();

        change(i,str,num,arr,my);
        System.out.println(i);
        System.out.println(str);
        System.out.println(num);
        System.out.println(Arrays.toString(arr));
        System.out.println(my.a);
    }

    public static void change(int j,String s,Integer n,int[]  a,MyData m){
        j+=1;
        s+="world";
        n+=1;
        a[0]+=1;
        m.a+=1;
        System.out.println(j);
        System.out.println(s);
        System.out.println(n);
        System.out.println(Arrays.toString(a));
        System.out.println(m.a);
    }
}

class MyData{
    int a=10;
}

