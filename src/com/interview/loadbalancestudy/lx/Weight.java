package com.interview.loadbalancestudy.lx;

/**
 * @author 王
 * @version 1.0
 * @create 2020/3/8 12:08
 */
// 增加一个Weight类，用来保存ip,weight(固定不变的原始权重)，currentWeight(当前会变化的权重)
public class Weight {
    private String ip;
    private Integer weight; //固定的，假如服务器权重为A:5,B:1,C:1,那么这里就为511
    private Integer currentWeight;

    public Weight(String ip, Integer weight, Integer currentWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }
}
