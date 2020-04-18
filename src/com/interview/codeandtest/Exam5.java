package com.interview.codeandtest;

public class Exam5 {
    static int s;
    int i;
    int j;
    {
        int i=1;
        i++;
        j++;
        s++;
    }
    public void test(int j){
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        Exam5 obj1 = new Exam5();       //i=0,j=1,s=1
        Exam5 obj2 = new Exam5();       //i=0,j=1,s=2
        obj1.test(10);      //i=1,j=1,s=3
        obj1.test(20);      //i=2,j=1,s=4
        obj2.test(30);      //i=1,j=1,s=5
        System.out.println(obj1.i+","+obj1.j+","+obj1.s);
        System.out.println(obj2.i+","+obj2.j+","+obj2.s);
    }
}
