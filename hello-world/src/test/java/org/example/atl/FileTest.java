package org.example.atl;

import org.junit.Test;

import java.util.HashSet;

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
}