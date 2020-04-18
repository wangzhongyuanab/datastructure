package com.interview.loadbalancestudy.random;

import com.interview.loadbalancestudy.ServerIps;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 9:38
 */
public class Random {
    public static String getServer(){
        java.util.Random random=new java.util.Random();
        int pos=random.nextInt(ServerIps.lists.size());
        return ServerIps.lists.get(pos);
    }
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            System.out.println(getServer());
        }
    }
}
