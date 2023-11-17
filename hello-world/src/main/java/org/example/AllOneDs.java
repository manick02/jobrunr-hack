package org.example;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class AllOneDs {
    private final LinkedHashMap<String,Integer> map = new LinkedHashMap<>(1000,.75f,true);
    public AllOneDs() {

    }
    public void inc(String key) {
        if (map.containsKey(key)) {
            Integer count = map.get(key);
            map.put("key",count+1);
        } else {
            map.put(key,0);
        }
    }

    public String getMaxKey() {
        return map.sequencedKeySet().getFirst();
    }
}
