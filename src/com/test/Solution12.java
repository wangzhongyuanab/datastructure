package com.test;

import java.util.HashMap;

/**
 * 整数转罗马数字
 */
public class Solution12 {
    public String intToRoman(int num) {
        int []values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<values.length;i++){
            while(num>values[i]){
                num-=values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
