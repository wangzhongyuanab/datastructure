package com.test;

/**
 *  报数
 */
public class Solution38 {
    public String countAndSay(int n) {
        int i=1;
        String res="1";
        while(i<n){
            int count=0;
            StringBuffer stringBuffer = new StringBuffer();
            char c=res.charAt(0);
            for (int j=0;j<=res.length();j++){
                if (j!=res.length()&&res.charAt(j)==c){
                    count++;
                }else {
                    stringBuffer.append(count);
                    stringBuffer.append(c);
                    if (j!=res.length()){
                        count=1;
                        c=res.charAt(j);
                    }
                }
            }
            res= stringBuffer.toString();
            i++;
        }
        return res;
    }
}
