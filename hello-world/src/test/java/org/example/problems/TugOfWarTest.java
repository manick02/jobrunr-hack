package org.example.problems;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TugOfWarTest {

    @Test
    public void creationTest() {
        int[] nums = new int[]{1, 4, 2, 3};
        TugOfWar tow = new TugOfWar(nums);
        assertNotNull(tow);
    }

    @Test
    public void segmentTest() {
        int[] nums = new int[]{1,4,2,3};
        TugOfWar tow = new TugOfWar(nums);
        List<int[]> segment = tow.segment();
        assertNotNull(segment);
    }


}