package org.example.lsm.bloom;

import static java.lang.Math.log;

public class BloomFilter {

    private final int size;

    public BloomFilter(int expectedInsertion, float falsePositiveTolerance) {
       this.size = (int)(-expectedInsertion * log(falsePositiveTolerance)/(log(2)*log(2)));
    }

    public void add(byte[] key){

    }

    public boolean mightContain(byte[] key) {
        return false;
    }

    public static BloomFilter readFromFile(String fileName) {
        return null;
    }

    public void writeToFile() {

    }
}
