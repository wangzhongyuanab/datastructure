package com.offer;

import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
    public static String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) {
            return "";
        }
        String[] strNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strNumbers.length; i++) {
            sb.append(strNumbers[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers=new int[]{3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }
}
