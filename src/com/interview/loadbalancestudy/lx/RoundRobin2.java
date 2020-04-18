package com.interview.loadbalancestudy.lx;

import com.interview.loadbalancestudy.ServerIps;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 10:55
 */
public class RoundRobin2 {
    private static Integer pos = 0;

    public static String getServer() {
        boolean sameWeight=true;
        int totalWeight=0;
//        for (Integer weight:ServerIps.WEIGHT_LIST.values()){
//            totalWeight+=weight;
//        }
        Object[] weights=ServerIps.WEIGHT_LIST.values().toArray();
        for (int i=0;i<weights.length;i++){
            Integer weight=(Integer) weights[i];
            totalWeight+=weight;

            if (sameWeight&&i>0&&!weight.equals(weights[i-1])){
                sameWeight=false;
            }
        }
        Integer sequenceNum = Sequence.getAndIncrement();
        Integer pos=sequenceNum%totalWeight;
        for (String ip : ServerIps.WEIGHT_LIST.keySet()) {
            Integer w = ServerIps.WEIGHT_LIST.get(ip);
            if (pos < w) {
                return ip;
            }
            pos = pos - w;
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
