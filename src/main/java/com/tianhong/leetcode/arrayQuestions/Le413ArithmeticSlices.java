package com.tianhong.leetcode.arrayQuestions;

import java.util.ArrayList;
import java.util.List;

public class Le413ArithmeticSlices {
    private List<List<Integer>> list;

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 1)
            return 0;
        list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> inner = list.get(i);
            if (inner.size() >= 3) {
                int diff = inner.get(1) - inner.get(0);
                boolean arti = true;
                for (int j = 2; j < inner.size(); j++) {
                    if (inner.get(j) - inner.get(j - 1) != diff) {
                        arti = false;
                        break;
                    }
                }
                if (arti) {
                    count++;
                }
            }
        }
        return count;
    }

    public void getSlices(int[] A, int index, ArrayList<Integer> temp) {
        if (index >= A.length) {
            return;
        }
        if (temp.size() > 0) {
            list.add(temp);
            return;
        }
        for (int i = index; i < A.length; i++) {
            temp.add(A[i]);
            getSlices(A, index + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
