package com.test;

/**
 *  IP 地址无效化
 */
public class Solution1108 {
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        String address="255.100.50.0";
        System.out.println(defangIPaddr(address));
    }
}
