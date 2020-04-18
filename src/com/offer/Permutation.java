package com.offer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Permutation {
    public static  ArrayList<String> Permutation(String str) {
        ArrayList<String> result=new ArrayList<String>();
        if(str.length()==0||str.equals("")){
            return result;
        }
        char[] chars=str.toCharArray();
        boolean vis[]=new boolean[chars.length];
        char[] temp=new char[chars.length];
        Set<String> set = new LinkedHashSet<>();
        permutation(0, temp, chars, set, vis);
        result.addAll(set);
        return result;
    }

    public static void permutation(int index, char[] temp, char[] chars, Set<String> set, boolean[] vis) {
        if(index==chars.length){
            set.add(new String(temp));
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(!vis[i]){
                temp[index]=chars[i];
                vis[i]=true;
                permutation(index+1, temp, chars, set, vis);
                vis[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Permutation("abc"));
    }
}
