package org.example.problems;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SplitArrayMinimiseLargestSumTest {

    @Test
    public void testSplitPositiveSolution() {
        SplitArrayMinimiseLargestSum solve = new SplitArrayMinimiseLargestSum();
        int[] nums = new int[] {1,2,3,1,4};
        int k = 3;
        int result = solve.canSolve(nums, k);
        assertEquals(4,result);
    }

}