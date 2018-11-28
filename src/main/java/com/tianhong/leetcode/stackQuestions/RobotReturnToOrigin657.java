package com.tianhong.leetcode.stackQuestions;

import java.util.HashMap;

public class RobotReturnToOrigin657 {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;
        char[] singleMoves = moves.toCharArray();
        for(char move : singleMoves){
            if(move == 'R')
                horizontal++;
            else if (move == 'L')
                horizontal--;
            else if (move == 'U')
                vertical++;
            else
                vertical--;
        }
        if(horizontal == 0 && vertical == 0)
            return true;
        else
            return false;
    }

    public boolean judgeCircle2(String moves){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = moves.toCharArray();
        for(int i = 0; i < chars.length; i++){
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        if(map.getOrDefault('U', 0).equals(map.getOrDefault('D', 0)) && map.getOrDefault('L', 0).equals(map.getOrDefault('R', 0)))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String test = "UD";
        RobotReturnToOrigin657 robot = new RobotReturnToOrigin657();
        Boolean ret = robot.judgeCircle2(test);
        System.out.println(ret);
    }
}
