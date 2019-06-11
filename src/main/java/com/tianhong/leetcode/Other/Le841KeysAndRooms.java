package com.tianhong.leetcode.Other;

import java.util.List;

public class Le841KeysAndRooms {
    private boolean[] taken;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        taken = new boolean[rooms.size()];
        floodFill(rooms, 0);
        for(int i = 0; i < taken.length; i++) {
            if(!taken[i]) {
                return false;
            }
        }
        return true;
    }

    public void floodFill(List<List<Integer>> rooms, int index) {
        if(taken[index]) {
            return;
        } else {
            taken[index] = true;
        }
        List<Integer> list = rooms.get(index);
        for(int i : list) {
            floodFill(rooms, i);
        }
    }
}
