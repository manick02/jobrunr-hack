package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LFUCacheTest {

    @Test
    public void putAndGet() {
        LFUCache cache = new LFUCache();
        Object obj1 = new Object();
        cache.put("Hello", obj1);
        Object obj2 = cache.get("Hello");
        assertEquals(obj1, obj2);
    }

    @Test
    public void putAngGetMulti() {
        LFUCache cache = new LFUCache();
        Object obj1 = new Object();
        cache.put("Hello", obj1);

        Object obj2 = new Object();
        cache.put("World", obj2);


        assertEquals(obj1, cache.get("Hello"));
        assertEquals(obj2, cache.get("World"));
    }

    @Test
    void putAndGetLimitWithFixedCacheSizeOfOne() {
        int size = 1;
        LFUCache cache = new LFUCache(size);
        Object obj1 = new Object();
        cache.put("Hello", obj1);

        Object obj2 = new Object();
        cache.put("World", obj2);


        assertNull(cache.get("Hello"));
        assertEquals(obj2, cache.get("World"));

        Object obj3 = new Object();
        cache.put("HelloWorld", obj3);
        assertNull(cache.get("World"));
    }

    @Test
    void putAndGetLimitWithFixedCacheSizeOfTwo() {
        int size = 2;
        LFUCache cache = new LFUCache(size);
        Object obj1 = new Object();
        cache.put("Hello", obj1);

        Object obj2 = new Object();
        cache.put("World", obj2);


        Object obj3 = new Object();
        cache.put("HelloWorld", obj3);
        assertNull(cache.get("World")); // assertNull(cache.get("World"))
    }
}