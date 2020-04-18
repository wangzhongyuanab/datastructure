package com.test;

/**
 *  无重复字符的最长子串
 */
public class SolutionThree {
    public int lengthOfLongestSubstring(String s) {
        //设置一个包含字符频率的数组
        int[] freq=new int[256];
        int l=0,r=-1;    //滑动窗口为s[l....r]
        int res=0;
        while(l<s.length()){
            if (r+1<s.length()&&freq[s.charAt(r+1)]==0){
                r++;
                freq[s.charAt(r)]++;
            }else {
                freq[s.charAt(l++)]--;
            }
            res=Math.max(res,r-l+1);
        }
        return res;
    }
}
