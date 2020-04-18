package com.algorithm;

/**
 * 汉诺塔
 * 分治算法
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(6,'A','B','C');
    }

    public static int hanoitower(int num,char a,char b,char c){
        int i=0;
        //如果只有一个盘
        if (num==1){
            i=1;
            System.out.println("第1个盘从"+a+"->"+c);
        }else {
            i++;
            //如果是n>=2,可以看作2个盘，1.最下边得一个盘，2.上面得盘
            //先把最上面得盘A-》B,移动过程会使用到c
            hanoitower(num-1, a, c, b);
            //最下面得盘A-》c
            System.out.println("第"+num+"个盘从 "+a+"->"+c);
            //把b盘所有得盘-》C,移动过程使用到a塔
            hanoitower(num-1,b,a,c);
        }
        return i;
    }
}
