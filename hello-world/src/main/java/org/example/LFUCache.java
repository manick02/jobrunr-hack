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

    TreeMap<Integer,List<String>> countBucket = new TreeMap<>();
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
     countBucket.computeIfAbsent(0, x -> new LinkedList<>()).add(key);
    }

    private void evictLessFrequentKey() {
      //  Map.Entry<String, Integer> min = Collections.min(this.keyAccessCount.entrySet(), Map.Entry.comparingByValue());
      //  String key = min.getKey();
        Integer count = this.countBucket.firstKey();
        String key = this.countBucket.get(count).removeFirst();
        if (this.countBucket.get(count).size() == 0) {
            this.countBucket.remove(count);
        }
        this.keyAccessCount.remove(key);
        this.map.remove(key);
    }

    public Object get(String key) {
        Integer count = this.keyAccessCount.get(key);
        if (count == null)
            return null;
        this.countBucket.get(count).remove(key);
        if (this.countBucket.get(count).size()==0) {
            this.countBucket.remove(count);
        }
        count++;
        this.keyAccessCount.put(key,count);
        this.countBucket.computeIfAbsent(count,x->new LinkedList<>()).add(key);
        return map.get(key);
    }


}
