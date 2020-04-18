package com;

import java.lang.reflect.Field;

public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }
    public static int value=123;
}

 class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}

class NotInitialization{
    public static void main(String[] args ){
        System.out.println(SubClass.value);
    }
}

class NotInitialization2{
    public static void main(String[] args ){
        SuperClass[] sca=new SuperClass[10];
    }
}