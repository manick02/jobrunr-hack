package org.example.problems;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KEqualSubsetSumsTest {

    @Test
    public  void partionsCorrect() {
     KEqualSubsetSums k = new KEqualSubsetSums();
     int[] nums = new int[]{2,1,1,2};
     boolean solve = k.solve(nums, 2);
     Assertions.assertTrue(solve);
    }

    @Test
    public  void cannotPartion() {
        KEqualSubsetSums k = new KEqualSubsetSums();
        int[] nums = new int[]{2,1,1,3};
        boolean solve = k.solve(nums, 2);
        Assertions.assertFalse(solve);
    }
}