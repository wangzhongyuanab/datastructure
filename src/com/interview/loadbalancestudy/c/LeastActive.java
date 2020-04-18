package com.interview.loadbalancestudy.c;

import com.interview.loadbalancestudy.ServerIps;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 13:46
 * 最小活跃次数
 */
public class LeastActive {
    private static String getServer(){
        //最小活跃次数的服务器
        Integer minActive=null;
        for (Integer num: ServerIps.ACTIVITY_LIST.values()){
            if (minActive==null||num<minActive){
                minActive=num;
            }
        }

        List<String> minActivityIps=new ArrayList<>();
        for (Map.Entry<String,Integer> entry: ServerIps.ACTIVITY_LIST.entrySet()){
            if (entry.getValue().equals(minActive)){
                minActivityIps.add(entry.getKey());
            }
        }
        if (minActivityIps.size()>1){
            //过滤出对应的ip和权重
            Map<String, Integer> weightList = new LinkedHashMap<String, Integer>
                    ();
            ServerIps.WEIGHT_LIST.forEach((ip, weight) -> {
                if (minActivityIps.contains(ip)) {
                    weightList.put(ip, ServerIps.WEIGHT_LIST.get(ip));
                }
            });
            int totalWeight = 0;
            boolean sameWeight = true; //如果所有权重都相等，那么随机一个就可以了

            Object[] weights = weightList.values().toArray();
            for (int i = 0; i < weights.length; i++) {
                Integer weight = (Integer) weights[i];
                totalWeight += weight;
                if (sameWeight && i > 0 && !weight.equals(weights[i - 1])) {
                    sameWeight = false;
                }
            }
            java.util.Random random = new java.util.Random();
            int randomPos = random.nextInt(totalWeight);
            if (!sameWeight) {
                for (String ip : weightList.keySet()) {
                    Integer value = weightList.get(ip);
                    if (randomPos < value) {
                        return ip;
                    }
                    randomPos = randomPos - value;
                }
            }
            return (String) weightList.keySet().toArray()[new
                    java.util.Random().nextInt(weightList.size())];
        }else{
            return minActivityIps.get(0);
        }
    }
}
