package com.trigger.mail.triggerMailDemo.service;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] inarr = {2, 54, 22, 14, 66};
        int[] outarr = specialIntegers(inarr);
        if (outarr.length == 0) {
            System.out.println(-1);
        } else {
            System.out.println(Arrays.toString(outarr));
        }
    }

    public static int[] specialIntegers(int[] inarr) {
        List<Integer> outList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : inarr) {
            set.add(num);
        }
        for (int num : inarr) {
            int sum = 0;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            if (set.contains(sum)) {
                outList.add(num);
            }
        }
        int[] outarr = new int[outList.size()];
        for (int i = 0; i < outList.size(); i++) {
            outarr[i] = outList.get(i);
        }
        return outarr;
    }
}

