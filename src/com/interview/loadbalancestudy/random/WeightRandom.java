package com.interview.loadbalancestudy.random;

import com.interview.loadbalancestudy.ServerIps;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 9:38
 */
public class WeightRandom {
    public static String getServer(){
        List<String> ips=new ArrayList<>();
        for (String ip:ServerIps.WEIGHT_LIST.keySet()){
            Integer weight=ServerIps.WEIGHT_LIST.get(ip);
            for (int i = 0; i <weight ; i++) {
                ips.add(ip);
            }
        }
        java.util.Random random=new java.util.Random();
        int pos=random.nextInt(ips.size());
        return ips.get(pos);
    }
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            System.out.println(getServer());
        }
    }
}
