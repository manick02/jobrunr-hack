package org.example.lsm.bloom;

import org.junit.Test;

import java.io.DataOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class BloomFilterTest {

    @Test
    public void bloomFilterConstructionTest() {
        int expectedInsertion = 10000;
        float falsePositiveTolerance = 0.001f;
        BloomFilter bloomFilter = new BloomFilter(expectedInsertion,falsePositiveTolerance);
        assertNotNull(bloomFilter);
    }

    @Test
    public void addKeyToBloomFilter() {
        int expectedInsertion = 10000;
        float falsePositiveTolerance = 0.001f;
        BloomFilter bloomFilter = new BloomFilter(expectedInsertion,falsePositiveTolerance);
        String key = "HelloWorld";
        bloomFilter.add(key.getBytes());
    }

    @Test
    public void checkIfKeyPresentInBloomFilter() {
        int expectedInsertion = 10000;
        float falsePositiveTolerance = 0.001f;
        BloomFilter bloomFilter = new BloomFilter(expectedInsertion,falsePositiveTolerance);
        String key = "HelloWorld";
        bloomFilter.add(key.getBytes());
        boolean contains = bloomFilter.mightContain(key.getBytes());
        assertTrue(contains);
        boolean mayNotContain = bloomFilter.mightContain("Hello".getBytes());
        assertFalse(mayNotContain);

    }

    @Test
    public void writeToBloomFilter() throws IOException {
        int expectedInsertion = 10000;
        float falsePositiveTolerance = 0.001f;
        BloomFilter bloomFilter = new BloomFilter(expectedInsertion,falsePositiveTolerance);
        String key = "HelloWorld";
        bloomFilter.add(key.getBytes());
        String fileName = "bloom.filter";
        bloomFilter.writeToFile(fileName);

    }
}