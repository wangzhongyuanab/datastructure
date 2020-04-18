package com.interview.loadbalancestudy.lx;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 11:13
 */
public class Sequence {
    private static Integer sequenceNum=0;

    public static Integer getAndIncrement(){
        return ++sequenceNum;
    }
}
