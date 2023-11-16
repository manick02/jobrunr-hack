package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListSpike {

    public static void main(String[] args) {
        ConcurrentSkipListMap<Long,String> skipListMap = new ConcurrentSkipListMap<>();
        Map<Long,String>  hashMap = new HashMap<>();
        Map<Long,String> linkedHashMap = new LinkedHashMap<>();
        generateMockData(skipListMap);
        generateMockData(hashMap);
        generateMockData(linkedHashMap);
//        longs.ceiling();
        System.out.println(skipListMap);
        System.out.println(hashMap);
        System.out.println(linkedHashMap);
    }

    private static void generateMockData(Map<Long, String> map) {
        map.put(2l,"Second");
        map.put(1l,"First");

    }
}
