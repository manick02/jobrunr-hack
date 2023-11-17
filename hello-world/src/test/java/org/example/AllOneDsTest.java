package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


// leetcode https://leetcode.com/problems/all-oone-data-structure/solutions/3963653/python-hashmap-doubly-linked-list/
public class AllOneDsTest {
    @Test
    public void allOneInstanceCreation() {
        AllOneDs ds = new AllOneDs();
        assertNotNull(ds);
    }

    @Test
    public void allOneInstanceMaxFreq() {
        AllOneDs ds = new AllOneDs();
        ds.inc("key1");
        ds.inc("key2");
        ds.inc("key2");
        ds.inc("key2");
        ds.inc("key1");
        String maxKey =  ds.getMaxKey();
        assertEquals(maxKey,"key2");
    }
}