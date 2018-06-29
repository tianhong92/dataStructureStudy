package com.tianhong.xiaoMA;

import java.util.*;

// find one duplicate integer in an integer array
public class findDuplicate {

    public static int findDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < array.length; i++) {
            if(set.contains(array[i])) {
                return array[i];
            }else{
                set.add(array[i]);
            }
        }
        return -1;
    }

    public static int findDuplicate2(int[] array) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < array.length; i++) {
            sb.append(array[i]+"");
        }
        for(int j = 0; j < array.length; j++) {
            if(sb.indexOf(array[j]+"") != sb.lastIndexOf(array[j]+"")) {
                return array[j];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 5, 2, 6};
        System.out.println(findDuplicate2(arr));

    }
}
