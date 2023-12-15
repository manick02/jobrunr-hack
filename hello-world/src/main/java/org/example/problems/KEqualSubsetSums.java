package org.example.problems;

import java.util.*;

public class KEqualSubsetSums {

    public boolean solve(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int len = nums.length;
        boolean[] used = new boolean[len];
        int segmentSum = sum / k;
        for (int i = 0; i < k; i++) {
            if (!solveUtility(nums, used, 0, 0, segmentSum)) {
                return false;
            }
        }

        for(int j  = 0; j < len; j++) {
            if (!used[j]) {
                return false;
            }
        }

        return true;
    }

    private boolean solveUtility(int[] nums, boolean[] used, int currentSum, int currentPos, int target) {

        if (target == currentSum)
            return true;
        if (!used[currentPos] && currentSum + nums[currentPos] <= target) {
            used[currentPos] = true;
            if (solveUtility(nums, used, currentSum + nums[currentPos], currentPos + 1, target)) {
                return true;
            } else {
                used[currentPos] = false;
            }
        }

        return solveUtility(nums, used, currentSum , currentPos + 1, target);
    }
}
