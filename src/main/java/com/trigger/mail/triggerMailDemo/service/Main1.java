package com.trigger.mail.triggerMailDemo.service;


import java.util.HashMap;
import java.util.Map;

public class Main1 {
    public static void main(String[] args) {
        int[] inarr = {34, 89, 6, 321, 53, 45, 2211, 81};
        int outnum = countPairs(inarr);
        System.out.println(outnum);
    }

    public static int countPairs(int[] inarr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : inarr) {
            int sum = getSumOfDigits(num);
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        System.out.println(map);
        int count = 0;
        for (int value : map.values()) {
            count += value / 2;
        }
        return count > 0 ? count : -1;
    }

    public static int getSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
