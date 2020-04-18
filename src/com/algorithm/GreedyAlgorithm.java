package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 贪心算法解决电台选择覆盖问题
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入map
        broadcasts.put("K1",hashSet1);
        broadcasts.put("K2",hashSet2);
        broadcasts.put("K3",hashSet3);
        broadcasts.put("K4",hashSet4);
        broadcasts.put("K5",hashSet5);

        HashSet<String> allAreas = new HashSet<>(); //存放所有地区
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        allAreas.add("广州");
        allAreas.add("深圳");

        //创建一个ArrayList存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，在遍历的过程中存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        //定义maxKey，保存在一次过程中，能够覆盖最大未覆盖地区的地区对应的电台key
        //如果maxkey不等于空，则会加入到selects
        String maxKey = null;
        while (allAreas.size()!=0){     //如果allAreas不为0，则表示还没有覆盖到所有的地区
            //每进行一次while
            maxKey=null;
            //遍历broadcasts
            for (String key:broadcasts.keySet()){
                //每进行一次for
                tempSet.clear();
                //当前这个key能覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas集合的交集，交集会赋给tempSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含的未覆盖地区比maxkey指向的集合地区还多
                //tempSet.size()>broadcasts.get(maxKey).size():体现了贪心算法.
                if (tempSet.size()>0&&
                        (maxKey==null||tempSet.size()>broadcasts.get(maxKey).size())){
                    maxKey=key;
                }
            }
            if(maxKey!=null){
                selects.add(maxKey);
                //将maxkey指向的广播电台覆盖的地区从allAreas中去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("得到的选择结果："+ selects);
    }
}
