package org.example.problems;

import java.util.Arrays;
import java.util.List;

public class MinNumOfTaps {

    public int solve(int[] ranges) {
        int length = ranges.length;
        int[] dp = new int[length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int i = 0;
        for (int range : ranges) {
            int left = Math.max(0, i - range);
            int right = Math.min(length, i + range);
            for (int j = left; j <= right; j++) {
                dp[j] = Math.min(dp[j],dp[j] == Integer.MAX_VALUE ? 1 : dp[left] + 1);
            }

            i++;
        }
        return dp[length - 1] != Integer.MAX_VALUE ? dp[length - 1] : -1;
    }

}
