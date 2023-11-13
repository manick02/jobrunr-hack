package org.example.atl;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class FileTest {

    @Test
    public void fileCreationTest() {
        String testFileName = "test";
        int testFileSize = 100;
        File file = new File(testFileName, testFileSize, new HashSet<String>() {
            {
                add("Collection1");
                add("Collection2");
            }
        });

        assertEquals(testFileName, file.getFileName());

        assertEquals(testFileSize, file.getFileSize());
    }

    @Test
    public void fileFlatteningTest() {
        String testFileName = "test";
        int testFileSize = 100;
        File file = new File(testFileName, testFileSize, new HashSet<String>() {
            {
                add("Collection1");
                add("Collection2");
            }
        });

        List<File> files = new LinkedList<>();
        files.add(file);
        List<String> fileCollections = files.stream().flatMap(x -> x.getCollections().stream()).collect(Collectors.toList());
        System.out.println(fileCollections.toString());
        List<String> fileCollections2 = files.stream().map(x->x.getCollections()).flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(fileCollections2.toString());
        List<AbstractMap.SimpleImmutableEntry<String, File>> fileCollections3 = files.stream().flatMap(x -> x.getCollections().stream().map(v -> new AbstractMap.SimpleImmutableEntry<>(v, x))).collect(Collectors.toList());
        fileCollections3.stream().forEach(System.out::println);

    }
}