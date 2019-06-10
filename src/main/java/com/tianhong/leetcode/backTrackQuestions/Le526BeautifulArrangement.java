package com.tianhong.leetcode.backTrackQuestions;

public class Le526BeautifulArrangement {
    private int count;
    public int countArrangement(int N) {
        if(N == 0)
            return 0;
        boolean[] used = new boolean[N + 1];
        count = 0;
        count(N, used, 1);
        return count;
    }

    public void count(int N, boolean[] used, int index) {
        if(index > N){
            count++;
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(!used[i] && (i % index == 0 || index % i == 0)){
                used[i] = true;
                count(N, used, index + 1);
                used[i] = false;
            }
        }
    }
}
