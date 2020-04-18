package com;

public class testAdd {
    public static void main(String[] args) {
        testAdd nowcoder = new testAdd();
        int i = 0;
        nowcoder.inc(i);
        i = i++;
        System.out.println(i);
    }

    void inc(int i){
        i++;
    }

}
