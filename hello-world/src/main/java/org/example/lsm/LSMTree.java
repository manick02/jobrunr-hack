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

    public byte[] fetch(byte[] key) {
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

}
