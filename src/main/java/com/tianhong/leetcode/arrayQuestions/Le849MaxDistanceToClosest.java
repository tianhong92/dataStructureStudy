package com.tianhong.leetcode.arrayQuestions;

public class Le849MaxDistanceToClosest {
    public int maxDistToClosest(int[] seats) {
        int count = 0;
        int max = 0;
        boolean twoSide = false;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 0){
                count++;
                if(i == 0) {
                    twoSide = true;
                } else if (i == seats.length - 1 && count > max){
                    max = count;
                }
            } else {
                if(twoSide){
                    max = count;
                    twoSide = false;
                } else if ((count + 1)/2 > max){
                    max = (count + 1)/2;
                }
                count = 0;
            }
        }
        return max;
    }

    public int maxDistToClosests(int[] seats) {
        int count = 0;
        int max = -1;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 0) {
                count++;
            } else {
                if(max == -1){
                    max = count;
                } else if ((count - 1)/2 > max) {
                    max = (count - 1)/2;
                }
            }
        }
        return count > max ? count : max;
    }

    public int maxDistToClosest2(int[] seats) {
        int size = 0, length  = 0;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 0) {
                length ++;
            } else if (seats[i] != 0) {
                if(seats[0] == 0 && size == 0) {
                    size = length;
                } else {
                    size = Math.max(size, (length + 1)/2);
                }
                length = 0;
            }
        }
        return Math.max(size, length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 0, 0};
        Le849MaxDistanceToClosest test = new Le849MaxDistanceToClosest();
        test.maxDistToClosest(arr);
    }
}
