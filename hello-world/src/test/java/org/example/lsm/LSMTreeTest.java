package org.example.lsm;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LSMTreeTest {
    @Test
    public void LSMTreeCreation() {
        LSMTree lsmTree = new LSMTree();
        assertNotNull(lsmTree);
    }

    @Test
    public void addToLSMTree() {
        LSMTree lsmTree = new LSMTree();
        String key = "hello";
        String value = "world";
        lsmTree.add(key.getBytes(),value.getBytes());
    }
}