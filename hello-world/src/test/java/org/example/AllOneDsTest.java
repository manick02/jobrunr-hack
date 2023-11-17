package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


// leetcode https://leetcode.com/problems/all-oone-data-structure/solutions/3963653/python-hashmap-doubly-linked-list/
// https://leetcode.com/problems/all-oone-data-structure/solutions/731468/hashmap-doublylinkedlist-strategy/
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

    @Test
    public void allOneInstanceNodeConstruction() {
        AllOneDs.Node node = new AllOneDs.Node();
        assertNotNull(node);
    }

    @Test
    public void addNodeafter() {
        AllOneDs.Node node = new AllOneDs.Node();
        node.keys.add("Hello");
        AllOneDs.Node after = new AllOneDs.Node();
        after.keys.add("world");
        AllOneDs.Node.addAfter(node,after);
        assertNotNull(node.next);
        assertNull(node.prev);
        assertNotNull(after.prev);
        assertNull(after.next);
        assertEquals(node,node.next.prev);
        assertEquals(after,after.prev.next);
    }
}