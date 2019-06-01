package com.tianhong.leetcode.Other;

public class Le1041RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        // 1 up, 2 left, 3 bot, 4 right
        int[] dirs = new int[]{1, 2, 3, 4};
        int cur = 1;
        int x = 0;
        int y = 0;
        for(int i = 0; i < instructions.length(); i++) {
            char ins = instructions.charAt(i);
            if(ins == 'L') {
                cur = (cur + 1) % 4;
            } else if (ins == 'R') {
                cur = (cur - 1) % 4;
                if(cur == 0)
                    cur = 4;
            } else {
                if(cur == 1){
                    y++;
                } else if (cur == 2) {
                    x--;
                } else if (cur == 3) {
                    y--;
                } else {
                    x++;
                }
            }
        }
        return (x == 0 && y == 0) || cur != 1;
    }
}
