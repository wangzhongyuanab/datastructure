package com.offer;

import java.util.ArrayList;
import java.util.TreeSet;

public class Permutation2 {

    public static ArrayList<String> Permutation2(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str==null||str.equals("")){
            return result;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> set = new TreeSet<>();
        permutation2(0, chars, set);
        result.addAll(set);
        return  result;
    }

    private static void permutation2(int index, char[] chars, TreeSet<String> set) {
        if (index==chars.length-1){
            set.add(new String(chars));
            return;
        }
        for(int i=index;i<chars.length;i++){
            swap(chars,index,i);
            permutation2(index+1, chars, set);
            swap(chars,index,i);
        }
    }


    public static void swap(char[] chars,int i,int j){
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }

    public static void main(String[] args) {
        System.out.println(Permutation2("abc"));
    }
}
