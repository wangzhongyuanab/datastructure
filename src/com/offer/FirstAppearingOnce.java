package com.offer;

public class FirstAppearingOnce {
    static int MAX_VALUE=1<<15;

    static int[] visited=new int[MAX_VALUE];

    static StringBuffer sb=new StringBuffer();

    public static void insert(char ch){
        if (visited[ch]==0){
            sb.append(ch);
        }
        visited[ch]++;
    }

    public static char FirstAppearingOnce(){
        for(int i=0;i<sb.length();i++){
            if (visited[sb.charAt(i)]==1){
                return sb.charAt(i);
            }else if (visited[sb.charAt(i)]>1){
                sb.delete(0,1);
                i-=1;
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        insert('g');
        insert('o');
        insert('o');
        insert('g');
        insert('l');
        insert('e');
        System.out.println(FirstAppearingOnce());
    }
}
