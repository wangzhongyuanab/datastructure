package com.interview.codeandtest;

import java.lang.reflect.Field;

public class App {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Integer a=1,b=2;
        System.out.println("before:a="+a+",b="+b);
        swap(a,b);
        System.out.println("after:a="+a+",b="+b);
    }

    public  static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
       Field field=Integer.class.getDeclaredField("value");
       field.setAccessible(true);
       Integer tmp=new Integer(a.intValue());
       field.set(a,b.intValue());
       field.set(b,tmp);
    }
}
