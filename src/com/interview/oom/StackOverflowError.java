package com.interview.oom;

public class StackOverflowError {
    public static void main(String[] args) {
         stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();   //Exception in thread "main" java.lang.StackOverflowError
    }
}
