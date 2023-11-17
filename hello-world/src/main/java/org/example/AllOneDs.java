package org.example;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class AllOneDs {
    static class Node {
        Set<String> keys;
        Node prev;
        Node next;

        public Node() {
            this.keys = new HashSet<>();
        }

        public static void addAfter(Node node, Node newNode) {
            Node temp = node.next;
            newNode.prev = node;
            newNode.next = temp;
            node.next = newNode;
            if (temp != null) {
                temp.prev = newNode;
            }
        }
    }

    private final LinkedHashMap<String, Integer> map = new LinkedHashMap<>(1000, .75f, true);

    public AllOneDs() {

    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Integer count = map.get(key);
            map.put("key", count + 1);
        } else {
            map.put(key, 0);
        }
    }

    public String getMaxKey() {
        return map.sequencedKeySet().getFirst();
    }
}
