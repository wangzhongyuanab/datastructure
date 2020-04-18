package com.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/17 下午11:16
 */
public class Solution433 {
    public static void main(String[] args) {
        String start="AAAAACCC";
        String end="AACCCCCC";
        String []bank=new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        minMutation(start,end,bank);
    }
    public static  int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;

        Set<String> bankSet = new HashSet<>();
        for(String b: bank) bankSet.add(b);

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(end)) return level;

                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c: charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
