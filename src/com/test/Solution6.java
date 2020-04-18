package com.test;

import java.awt.font.FontRenderContext;

/**
 * Z 字形变换
 */
//时间复杂度和空间复杂度都是o（n）
public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows<=1) return s;
        StringBuilder[] sb=new StringBuilder[numRows];
        for (int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");
        }
        for (int i=0;i<s.length();i++){
            int index=i%(2*numRows-2);
            index=index<numRows?index:2*numRows-2-index;
            sb[index].append(s.charAt(i));
        }
        for (int i=0;i<sb.length;i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
