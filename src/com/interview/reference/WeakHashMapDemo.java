package com.interview.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        //myHashmap();
        myWeakHashMap();
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "hashmap";
        map.put(key, value);
        System.out.println(map);

        key = null;

        System.gc();
        System.out.println(map);
    }

    private static void myHashmap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "hashmap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.gc();
        System.out.println(map);
    }
}
