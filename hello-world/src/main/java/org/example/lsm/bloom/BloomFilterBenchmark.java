package org.example.lsm.bloom;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@OutputTimeUnit(TimeUnit.SECONDS)
public class BloomFilterBenchmark {

    static final int MIN_BYTES_LENGTH = 10, MAX_BYTES_LENGTH = 500;
    static Random rn = new Random();

    @Benchmark
    public void add(BloomState s) {
        s.f.add(s.keys[s.index]);
        s.index = (s.index + 1) % BloomState.N;
    }

    @Benchmark
    public void contains(BloomState s, Blackhole bh) {
        bh.consume(s.f.mightContain(s.keys[s.index]));
        s.index = (s.index + 1) % BloomState.N;
    }

    @State(Scope.Thread)
    public static class BloomState {

        static final int N = 1000000;

        BloomFilter f;
        byte[][] keys = new byte[N][];
        int index;

        @Setup
        public void setup() {
            f = new BloomFilter(N, 0.01f);
            index = 0;
            for (int i = 0; i < N; i++)
                keys[i] = getRandomByteArray();

            for (int i = 0; i < N / 2; i++)
                f.add(keys[i]);
        }

        private byte[] getRandomByteArray() {
            byte[] bytes = new byte[rn.nextInt(MIN_BYTES_LENGTH, MAX_BYTES_LENGTH)];
            rn.nextBytes(bytes);
            return bytes;
        }

    }
}