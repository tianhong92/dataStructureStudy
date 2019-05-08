package com.tianhong.leetcode.dynamicProgramming;

import java.util.List;

/**
 * @author TianhongWang
 * @since 2019/4/23
 */
public class Le120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() < 1)
            return 0;
        int[] minimum = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                minimum[j] = triangle.get(i).get(j) + Math.min(minimum[j], minimum[j + 1]);
            }
        }

        return minimum[0];
    }
}
