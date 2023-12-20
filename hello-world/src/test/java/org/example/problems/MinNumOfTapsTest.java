package org.example.problems;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinNumOfTapsTest {

    @Test
    public void canTest() {
        int[] range = new int[] {3,4,1,1,0,0};
        int expected = 1;
        MinNumOfTaps taps = new MinNumOfTaps();
        int solve = taps.solve(range);
        assertEquals(expected,solve);
    }
}