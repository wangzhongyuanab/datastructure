package com.offer;

import java.util.HashMap;

public class Test {

        public static  int FirstNotRepeatingChar(String str) {
            if(str!=null){
                HashMap<Character,Integer> map=new HashMap<>();
                for(int i=0;i<str.length();i++){
                    map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
                }
                for(int i=0;i<str.length();i++){
                    if(map.get(str.charAt(i))==1){
                        return i;
                    }
                }
            }
            return -1;
        }

    public static void main(String[] args) {
        String str="google";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
