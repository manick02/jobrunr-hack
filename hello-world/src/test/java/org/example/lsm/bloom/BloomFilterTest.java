package org.example.lsm.bloom;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BloomFilterTest {

    @Test
    public void bloomFilterConstructionTest() {
        int expectedInsertion = 10000;
        float falsePositiveTolerance = 0.001f;
        BloomFilter bloomFilter = new BloomFilter(expectedInsertion,falsePositiveTolerance);
        assertNotNull(bloomFilter);
    }
}