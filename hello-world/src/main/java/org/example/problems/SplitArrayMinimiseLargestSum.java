package org.example.problems;

import java.util.Arrays;
import java.util.OptionalInt;

// lc 410 split array which minimises largest sum,
// https://www.youtube.com/watch?v=YUF3_eBdzsk
public class SplitArrayMinimiseLargestSum {

    public int canSolve(int[] nums, int k) {
        int maxValue = Arrays.stream(nums).sum();
        OptionalInt min = Arrays.stream(nums).max();
        int minValue = min.getAsInt();
        int left = minValue;
        int right = maxValue;
        int result = right;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if (canSplit(nums,mid,k)) {
               result = mid;
               right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private boolean canSplit(int[] nums, int mid, int k) {
        int subArray = 0;
        int sum = 0;
        for(int num:nums) {
           sum+=num;
           if (sum>mid) {
               sum = num;
               subArray++;
           }
        }
        return  subArray<=k-1;
    }
}
