package com.interview.codeandtest;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MethodTest {
    public void test(String t1){
        System.out.println("111");
    }

    public static void main(String[] args) {
        try {
            Method method = MethodTest.class.getMethod("test", new Class[]{String.class});
            for (Parameter parameter : method.getParameters()) {
                System.out.println(parameter.getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
