package com.tianhong.xiaoMA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintMinNumber {

    public static String PrintMinNumber(int[] numbers) {
        String result = "";
        int length = numbers.length;
        if(length < 1) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < length; i++) {
            list.add(numbers[i]);
        }
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String a = o1 + "" + o2;
                String b = o2 + "" + o1;
                if(Integer.valueOf(a) < Integer.valueOf(b)) {
                    return -1;
                } else if (a == b) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };

        Collections.sort(list, comparator);

        for(int i = 0; i < length; i++) {
            result += list.get(i).toString();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{222, 111, 333, 96, 555};
        System.out.println(PrintMinNumber(test));
    }
}
