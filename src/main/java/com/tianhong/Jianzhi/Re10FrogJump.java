package com.tianhong.Jianzhi;

/**
 * @Author: TianhongWang
 * @Date: 2018/12/4
 * @Description
 */
public class Re10FrogJump {
    // 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
    // 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

    public static int JumpFloor(int n){
        if(n <= 2)
            return n;
        return JumpFloor(n - 1 ) + JumpFloor(n - 2);
    }


    // 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。
    // 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

    public static int JumpFloor2(int n){
        if(n < 1) {
            return 1;
        }
        if( n <= 2 && n > 0)
            return n;
        int total = 0;
        for(int i = 1; i <= n; i++){
            total += JumpFloor2(n - i);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor2(4));
    }
}
