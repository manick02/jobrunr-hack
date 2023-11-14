package org.example.atl;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class QueryFileCollectionTest {

    @Test
    public void queryFileSizeGivenEmptyFile() {
        List<File> files = new LinkedList<>();
        QueryFileCollection qfc = new QueryFileCollection(files);
        assertEquals(0, qfc.getAllFileSize());
    }

    @Test
    public void queryFileSizeGivenNonEmptyFiles() {
        List<File> files = new LinkedList<>();
        files.add(new File("File1", 100, new HashSet<String>() {
            {
                add("Collection1");
                add("Collection2");
            }
        }));
        files.add(new File("File2", 200, new HashSet<String>() {
            {
                add("Collection1");
            }
        }));
        QueryFileCollection qfc = new QueryFileCollection(files);
        assertEquals(300, qfc.getAllFileSize());
    }

    @Test
    public void queryTopNCollection() {
        List<File> files = new LinkedList<>();
        files.add(new File("File1", 100, new HashSet<String>(){{
            add("Collection1");

            add("Collection2");

        }}));
        QueryFileCollection qfc = new QueryFileCollection(files);
        Set<String> topNCollectionBySize = qfc.getTopNCollectionBySize();
        assertNotNull(topNCollectionBySize);

    }

    @Test
    public void spikeCollectionSummary() {
        List<File> files = new LinkedList<>();
        files.add(new File("File1", 100, new HashSet<String>(){{
            add("Collection1");

            add("Collection2");

        }}));
        files.add(new File("File2", 100, new HashSet<String>(){{
            add("Collection2");
        }}));
        files.add(new File("File2", 500, new HashSet<String>(){{
            add("Collection3");
        }}));
        List<CollectionSummary> collectionSummaries = files.stream().flatMap(y -> y.getCollections().stream().map(collection -> new CollectionSummary(collection, y.getFileSize()))).collect(Collectors.toList());
        Map<String, IntSummaryStatistics> collect = collectionSummaries.stream().collect(Collectors.groupingBy(CollectionSummary::getCollectionName, Collectors.summarizingInt(CollectionSummary::getSize)));
//        System.out.println(collectionSummaries);
        System.out.println(collect);
        ArrayList<Map.Entry<String, IntSummaryStatistics>> entries = new ArrayList<>(collect.entrySet());
        entries.sort((e1,e2)->Long.compare(e1.getValue().getSum(),e2.getValue().getSum()));
        entries.sort((e1,e2)->Long.compare(e1.getValue().getSum(),e2.getValue().getSum()));
        System.out.println(entries.reversed());
    }

    class CollectionSummary {
        public String getCollectionName() {
            return collectionName;
        }

        public int getSize() {
            return size;
        }

        String collectionName;
        int size;
        CollectionSummary(String collectionName, int size) {
            this.collectionName = collectionName;
            this.size = size;
        }
    }


}