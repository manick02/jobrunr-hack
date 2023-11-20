package org.example;

import java.util.*;

/**
 * LFU Cache implementation without using LinkedHashMap
 * https://www.enjoyalgorithms.com/blog/least-frequently-used-cache
 */
public class LFUCache {
    private static final int  defaultSize = 100;
    Map<String,Object> map = new HashMap<>();
    Map<String,Integer> keyAccessCount = new HashMap<>();
    private int size = 0;
    private int currentSize = 0;

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
    if (this.map.size() == size) {
        evictLessFrequentKey(); // this is o(n) for insert and does not know what key to evict in case of lot of keys have same minn freq
    }

     map.put(key,value);
     keyAccessCount.put(key,0);

    }

    private void evictLessFrequentKey() {
        Map.Entry<String, Integer> min = Collections.min(this.keyAccessCount.entrySet(), Map.Entry.comparingByValue());
        String key = min.getKey();
        this.keyAccessCount.remove(key);
        this.map.remove(key);
    }

    public Object get(String key) {
        Integer count = this.keyAccessCount.get(key);
        if (count == null)
            return null;
        this.keyAccessCount.put(key,count+1);
        return map.get(key);
    }


}
