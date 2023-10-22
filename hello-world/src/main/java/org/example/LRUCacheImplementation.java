package org.example;

import java.util.LinkedHashMap;
import java.util.Map;


// Refered from iot db
public class LRUCacheImplementation {

    public static void main(String[] args) {
        int cacheSize = 5;
        LinkedHashMap<String, String> lruCache =  new LinkedHashMap<String, String>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {

                return size() > cacheSize;
            }
        };

        lruCache.put("First","First");
        lruCache.put("Second","Second");
        lruCache.put("Third","Third");
        lruCache.put("Fourth","Fourth");
        lruCache.put("Fifth","Fifth");
        System.out.println(lruCache.get("First")); // Second becomes the least org
        lruCache.put("Sixth","Sixth"); // Sixth should remove second from cache
        System.out.println(lruCache.keySet().contains("Second")); // This should be false


    }
}
