package org.example.atl;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
}