package com.interview.loadbalancestudy.lx;

import com.interview.loadbalancestudy.ServerIps;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 10:55
 */
public class RoundRobin3 {

    //string代表ip
    private static Map<String, Weight> weightMap = new HashMap<String, Weight>();

    public static String getServer() {

        int totalWeight = ServerIps.WEIGHT_LIST.values().stream().reduce(0, (w1, w2) -> w1+w2);

        // 初始化weightMap，初始时将currentWeight赋值为weight
        if (weightMap.isEmpty()){
            ServerIps.WEIGHT_LIST.forEach((key,value)->{
                weightMap.put(key,new Weight(key,value,value));
            });
        }
        // 找出currentWeight最大值
        Weight maxCurrentWeight = null;
        for (Weight weight : weightMap.values()) {
            if (maxCurrentWeight == null || weight.getCurrentWeight() >
                    maxCurrentWeight.getCurrentWeight()) {
                maxCurrentWeight = weight;
            }
        }

        //将currentWeight减去总权重和
        maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getCurrentWeight()-totalWeight);

        //所有ip的currentWeight统一加上原始权重
        for (Weight weight : weightMap.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }
        return maxCurrentWeight.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
