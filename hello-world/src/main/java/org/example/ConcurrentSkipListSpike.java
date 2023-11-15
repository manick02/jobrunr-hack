package org.example;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListSpike {

    public static void main(String[] args) {
        ConcurrentSkipListMap<Long,String> skipListMap = new ConcurrentSkipListMap<>();
        skipListMap.put(1l,"First");
        skipListMap.put(2l,"Second");
        NavigableSet<Long> longs = skipListMap.navigableKeySet();
//        longs.ceiling();
        System.out.println(skipListMap);
    }
}
