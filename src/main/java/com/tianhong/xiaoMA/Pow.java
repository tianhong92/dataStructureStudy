package com.tianhong.xiaoMA;

/**
 * @author TianhongWang
 * @since 2019/2/15
 */
// 计算x的n次方, n > 0
public class Pow {
    public double pow(double x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double temp = pow(x, n/2);
        if(n%2 == 0){
            return temp*temp;
        }else{
            return temp*temp*x;
        }
    }

    public static void main(String[] args) {
        Pow test = new Pow();
        System.out.println(test.pow(3, 5));
    }
}
