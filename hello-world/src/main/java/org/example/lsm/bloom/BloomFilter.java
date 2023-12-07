package org.example.lsm.bloom;

import org.apache.commons.codec.digest.MurmurHash3;

import java.io.*;

import static java.lang.Math.ceil;
import static java.lang.Math.log;

public class BloomFilter {

    private final int size;
    private final int hashCount;
    private final long[] bits;

    public BloomFilter(int expectedInsertion, float falsePositiveTolerance) {
        this.size = (int) (-expectedInsertion * log(falsePositiveTolerance) / (log(2) * log(2)));
        this.hashCount = (int) ceil(-log(falsePositiveTolerance) / log(2));
        this.bits = new long[(int) ceil(size / 64.0)];
    }

    public BloomFilter(int size, int hashCount, long[] bits) {
        this.size = size;
        this.hashCount = hashCount;
        this.bits = bits;
    }



    public void add(byte[] key) {

        long[] hash = getHash(key);
        long h1 = hash[0], h2 = hash[1];

        for (int i = 0; i < hashCount; i++) {
            int bit = (int) Math.abs((h1 + i * h2) % size);
            bits[bit / 64] |= 1L << (bit % 64);

        }

    }

    private long[] getHash(byte[] key) {
        long[] hashes = MurmurHash3.hash128x64(key, 0, key.length, 0);
        return hashes;
    }

    public boolean mightContain(byte[] key) {
        long[] hash = getHash(key);
        long h1 = hash[0], h2 = hash[1];
        for(int i = 0; i < hashCount; i++) {
            int bit = (int) Math.abs((h1 + i * h2) % size);
            if ((bits[bit / 64] & (1L << (bit % 64))) == 0)
                return false;
        }
        return true;
    }



    public void writeToFile(String fileName) throws IOException {
        DataOutputStream dao = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
        dao.writeInt(size);
        dao.writeInt(hashCount);
        dao.writeInt(bits.length);
        for(long bit:bits) {
            dao.writeLong(bit);
        }
        dao.flush();
        dao.close();


    }

    public static BloomFilter readFromFile(String fileName) throws IOException {
        DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        int size = din.readInt();
        int hashCount = din.readInt();
        int length = din.readInt();
        long[] bits = new long[length];
        for (int i = 0; i < length; i++) {
            bits[i] = din.readLong();
        }

        din.close();
        return new BloomFilter(size,hashCount,bits);
    }
}
