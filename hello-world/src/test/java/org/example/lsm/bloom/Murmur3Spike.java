package org.example.lsm.bloom;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.Test;

import java.util.Arrays;

public class Murmur3Spike {
    @Test
    public void testGetHash() {
        byte[] key = "HelloWorld".getBytes();
        long[] hash = MurmurHash3.hash128x64(key, 0, key.length, 0);
        Arrays.stream(hash).forEach(hashed->System.out.println(hashed));
    }
}
