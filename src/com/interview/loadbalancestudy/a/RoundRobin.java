package com.interview.loadbalancestudy.a;

import com.interview.loadbalancestudy.ServerIps;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 10:55
 * 轮询;
 */
public class RoundRobin {
    private static Integer pos=0;
    public static String getServer() {
        String ip="";
        synchronized (pos) {
            if (pos>=ServerIps.lists.size()) {
                pos=0;
            }
            ip = ServerIps.lists.get(pos);
            pos++;
        }
        return ip;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println(getServer());
        }
    }
}
