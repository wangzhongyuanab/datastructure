package com.interview.loadbalancestudy;

import java.util.*;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 9:36
 */
public class ServerIps {
    public static final List<String> lists=new ArrayList<>();
    static{
        lists.add("192.168.1.1");
        lists.add("192.168.1.2");
        lists.add("192.168.1.3");
        lists.add("192.168.1.4");
        lists.add("192.168.1.5");
        lists.add("192.168.1.6");
        lists.add("192.168.1.7");
        lists.add("192.168.1.8");
        lists.add("192.168.1.9");
        lists.add("192.168.1.10");
    }
    public static final Map<String,Integer> WEIGHT_LIST=new HashMap<>();
    static{
        WEIGHT_LIST.put("192.168.1.1",2);
        WEIGHT_LIST.put("192.168.1.2",8);
        WEIGHT_LIST.put("192.168.1.3",1);
        WEIGHT_LIST.put("192.168.1.4",9);
        WEIGHT_LIST.put("192.168.1.5",3);
        WEIGHT_LIST.put("192.168.1.6",7);
        WEIGHT_LIST.put("192.168.1.7",4);
        WEIGHT_LIST.put("192.168.1.8",6);
        WEIGHT_LIST.put("192.168.1.9",2);
        WEIGHT_LIST.put("192.168.1.10",8);
    }
    // 服务器当前的活跃次数
    public static final Map<String, Integer> ACTIVITY_LIST = new LinkedHashMap<String,
                Integer>();
    static {
        ACTIVITY_LIST.put("192.168.0.1", 2);
        ACTIVITY_LIST.put("192.168.0.2", 0);
        ACTIVITY_LIST.put("192.168.0.3", 1);
        ACTIVITY_LIST.put("192.168.0.4", 3);
        ACTIVITY_LIST.put("192.168.0.5", 0);
        ACTIVITY_LIST.put("192.168.0.6", 1);
        ACTIVITY_LIST.put("192.168.0.7", 4);
        ACTIVITY_LIST.put("192.168.0.8", 2);
        ACTIVITY_LIST.put("192.168.0.9", 7);
        ACTIVITY_LIST.put("192.168.0.10", 3);
    }
}
