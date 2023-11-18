package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LFU Cache implementation without using LinkedHashMap
 * https://www.enjoyalgorithms.com/blog/least-frequently-used-cache
 */
public class LFUCache {
    private static final int  defaultSize = 100;
    Map<String,Object> map = new HashMap<>();
    private int size = 0;

    /**
     * 
     */
    public LFUCache() {
        this(defaultSize);
    }

    public LFUCache(int size) {
        this.size = size;
    }

    public void put(String key, Object value){
     map.put(key,value);
    }

    public Object get(String key) {
        return map.get(key);
    }
}
