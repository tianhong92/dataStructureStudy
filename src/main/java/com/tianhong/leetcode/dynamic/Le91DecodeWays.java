package com.tianhong.leetcode.dynamic;

public class Le91DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s == "" || s.equals("0") || s.charAt(0) == '0')
            return 0;
        char[] cs = s.toCharArray();
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int res = 0;
            char cur = cs[i - 1];
            char pre = cs[i - 2];
            int plus = Integer.valueOf(s.substring(i - 2, i));
            if(cur != '0'){
                res += dp[i - 1];
            }
            if(pre != '0' && plus >= 10 && plus <= 26){
                res += dp[i - 2];
            }
            dp[i] = res;
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String str = "12";
        Le91DecodeWays test = new Le91DecodeWays();
        test.numDecodings(str);
    }
}
