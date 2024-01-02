package org.example.lsm;

import static java.lang.Math.log;

public class LSMTree {
    private int numLevels;
    private Node sentinel;
    public LSMTree(int numElements) {
        this.numLevels = (int) Math.ceil(log(numElements)/log(2));
        this.sentinel = new Node(null,null,numLevels);
    }
    public void add(byte[] key, byte[] value) {
        throw new RuntimeException("Not Implemented");
    }

    public void remove(byte[] key) {
        throw new RuntimeException("Not Implemented");
    }

    public byte[] get(byte[] key) {
        throw new RuntimeException("Not Implemented");
    }

    static class Node {
        byte[] key;
        byte[] value;
        Node[] next;
        Node(byte[] key, byte[] value,int numOfLevels) {
            this.key = key;
            this.value = value;
            this.next = new Node[numOfLevels];
        }
    }

    static public int compare(byte[] a, byte[] b) {

        if (a == null)
            return b == null ? 0 : -1;

        int aLen = a.length;
        int bLen = b.length;

        if (aLen != bLen)
            return aLen < bLen ? -1 : 1;

        for (int i = 0; i < aLen; i++) {
            byte aByte = a[i];
            byte bByte = b[i];
            if (aByte != bByte)
                return aByte < bByte ? -1 : 1;
        }
        return 0;
    }

}
